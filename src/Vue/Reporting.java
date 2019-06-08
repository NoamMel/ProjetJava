// import javax.swing.JPanel;
//
// import org.jfree.chart.*;
// import org.jfree.chart.ChartPanel;
// import org.jfree.chart.JFreeChart;
// import org.jfree.data.general.*;
// import org.jfree.data.general.PieDataset;
// import org.jfree.ui.*;
// import org.jfree.ui.RefineryUtilities;
//
// public class Reporting extends ApplicationFrame {
//
//    public Reporting( String title ) {
//       super( title );
//       setContentPane(createDemoPanel( ));
//    }
//
//    private static PieDataset createDataset( ) {
//       DefaultPieDataset dataset = new DefaultPieDataset( );
//       dataset.setValue( "IPhone 5s" , new Double( 20 ) );
//       dataset.setValue( "SamSung Grand" , new Double( 20 ) );
//       dataset.setValue( "MotoG" , new Double( 40 ) );
//       dataset.setValue( "Nokia Lumia" , new Double( 10 ) );
//       return dataset;
//    }
//
//    private static JFreeChart createChart( PieDataset dataset ) {
//       JFreeChart chart = ChartFactory.createPieChart(
//          "Mobile Sales",   // chart title
//          dataset,          // data
//          true,             // include legend
//          true,
//          false);
//
//       return chart;
//    }
//
//    public static JPanel createDemoPanel( ) {
//       JFreeChart chart = createChart(createDataset( ) );
//       return new ChartPanel( chart );
//    }
//
//    public static void main( String[ ] args ) {
//       Reporting demo = new Reporting( "Mobile Sales" );
//       demo.setSize( 560 , 367 );
//       RefineryUtilities.centerFrameOnScreen( demo );
//       demo.setVisible( true );
//    }
// }
