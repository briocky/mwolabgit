var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

var version = typeof(Program).Assembly.GetName().Version;
var formattedVersion = $"{version.Major}.{version.Minor}.{version.Build}";

app.MapGet("/", () => $"!Hello World! Version: {formattedVersion}");

app.Run();
