import HtmlWebpackPlugin from "html-webpack-plugin";

let webpackConfig = {
    entry: "./src/index.js",
    module: {
        rules: [{
            use: [
                {
                    loader: "babel-loader",
                    test: /\.js$/
                }
            ]
        }
        ]
    },
    output: {
        path: "build",
        filename: "bundle.js"
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: "src/index.ejs"
        })
    ]
};

module.exports = webpackConfig;
