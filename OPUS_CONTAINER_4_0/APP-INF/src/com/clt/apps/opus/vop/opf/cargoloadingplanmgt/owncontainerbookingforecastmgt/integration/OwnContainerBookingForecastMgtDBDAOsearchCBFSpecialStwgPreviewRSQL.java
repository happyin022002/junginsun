/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialStwgPreviewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialStwgPreviewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFSpecialStwgPreview
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialStwgPreviewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialStwgPreviewRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT DECODE(POD,'G.Total','G.Total',SUBSTR(POD,1,5)) AS POD," ).append("\n"); 
		query.append("       MLB" ).append("\n"); 
		query.append("#if (${qty1} != '')" ).append("\n"); 
		query.append("       ,OPR1," ).append("\n"); 
		query.append("       ST1_20_OPR1,  ST1_2H_OPR1,  ST1_40_OPR1,  ST1_4H_OPR1,  ST1_45_OPR1,  ST2_20_OPR1,  ST2_2H_OPR1,  ST2_40_OPR1,  ST2_4H_OPR1,  ST2_45_OPR1," ).append("\n"); 
		query.append("       ST3_20_OPR1,  ST3_2H_OPR1,  ST3_40_OPR1,  ST3_4H_OPR1,  ST3_45_OPR1,  ST4_20_OPR1,  ST4_2H_OPR1,  ST4_40_OPR1,  ST4_4H_OPR1,  ST4_45_OPR1," ).append("\n"); 
		query.append("       ST5_20_OPR1,  ST5_2H_OPR1,  ST5_40_OPR1,  ST5_4H_OPR1,  ST5_45_OPR1,  ST6_20_OPR1,  ST6_2H_OPR1,  ST6_40_OPR1,  ST6_4H_OPR1,  ST6_45_OPR1," ).append("\n"); 
		query.append("       ST7_20_OPR1,  ST7_2H_OPR1,  ST7_40_OPR1,  ST7_4H_OPR1,  ST7_45_OPR1,  ST8_20_OPR1,  ST8_2H_OPR1,  ST8_40_OPR1,  ST8_4H_OPR1,  ST8_45_OPR1," ).append("\n"); 
		query.append("       ST9_20_OPR1,  ST9_2H_OPR1,  ST9_40_OPR1,  ST9_4H_OPR1,  ST9_45_OPR1,  ST10_20_OPR1, ST10_2H_OPR1, ST10_40_OPR1, ST10_4H_OPR1, ST10_45_OPR1," ).append("\n"); 
		query.append("       ST11_20_OPR1, ST11_2H_OPR1, ST11_40_OPR1, ST11_4H_OPR1, ST11_45_OPR1, ST12_20_OPR1, ST12_2H_OPR1, ST12_40_OPR1, ST12_4H_OPR1, ST12_45_OPR1," ).append("\n"); 
		query.append("       ST13_20_OPR1, ST13_2H_OPR1, ST13_40_OPR1, ST13_4H_OPR1, ST13_45_OPR1, ST14_20_OPR1, ST14_2H_OPR1, ST14_40_OPR1, ST14_4H_OPR1, ST14_45_OPR1," ).append("\n"); 
		query.append("       ST15_20_OPR1, ST15_2H_OPR1, ST15_40_OPR1, ST15_4H_OPR1, ST15_45_OPR1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${qty2} != '')" ).append("\n"); 
		query.append("       ,OPR2," ).append("\n"); 
		query.append("       ST1_20_OPR2,  ST1_2H_OPR2,  ST1_40_OPR2,  ST1_4H_OPR2,  ST1_45_OPR2,  ST2_20_OPR2,  ST2_2H_OPR2,  ST2_40_OPR2,  ST2_4H_OPR2,  ST2_45_OPR2," ).append("\n"); 
		query.append("       ST3_20_OPR2,  ST3_2H_OPR2,  ST3_40_OPR2,  ST3_4H_OPR2,  ST3_45_OPR2,  ST4_20_OPR2,  ST4_2H_OPR2,  ST4_40_OPR2,  ST4_4H_OPR2,  ST4_45_OPR2," ).append("\n"); 
		query.append("       ST5_20_OPR2,  ST5_2H_OPR2,  ST5_40_OPR2,  ST5_4H_OPR2,  ST5_45_OPR2,  ST6_20_OPR2,  ST6_2H_OPR2,  ST6_40_OPR2,  ST6_4H_OPR2,  ST6_45_OPR2," ).append("\n"); 
		query.append("       ST7_20_OPR2,  ST7_2H_OPR2,  ST7_40_OPR2,  ST7_4H_OPR2,  ST7_45_OPR2,  ST8_20_OPR2,  ST8_2H_OPR2,  ST8_40_OPR2,  ST8_4H_OPR2,  ST8_45_OPR2," ).append("\n"); 
		query.append("       ST9_20_OPR2,  ST9_2H_OPR2,  ST9_40_OPR2,  ST9_4H_OPR2,  ST9_45_OPR2,  ST10_20_OPR2, ST10_2H_OPR2, ST10_40_OPR2, ST10_4H_OPR2, ST10_45_OPR2," ).append("\n"); 
		query.append("       ST11_20_OPR2, ST11_2H_OPR2, ST11_40_OPR2, ST11_4H_OPR2, ST11_45_OPR2, ST12_20_OPR2, ST12_2H_OPR2, ST12_40_OPR2, ST12_4H_OPR2, ST12_45_OPR2," ).append("\n"); 
		query.append("       ST13_20_OPR2, ST13_2H_OPR2, ST13_40_OPR2, ST13_4H_OPR2, ST13_45_OPR2, ST14_20_OPR2, ST14_2H_OPR2, ST14_40_OPR2, ST14_4H_OPR2, ST14_45_OPR2," ).append("\n"); 
		query.append("       ST15_20_OPR2, ST15_2H_OPR2, ST15_40_OPR2, ST15_4H_OPR2, ST15_45_OPR2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${qty3} != '')" ).append("\n"); 
		query.append("       ,OPR3," ).append("\n"); 
		query.append("       ST1_20_OPR3,  ST1_2H_OPR3,  ST1_40_OPR3,  ST1_4H_OPR3,  ST1_45_OPR3,  ST2_20_OPR3,  ST2_2H_OPR3,  ST2_40_OPR3,  ST2_4H_OPR3,  ST2_45_OPR3," ).append("\n"); 
		query.append("       ST3_20_OPR3,  ST3_2H_OPR3,  ST3_40_OPR3,  ST3_4H_OPR3,  ST3_45_OPR3,  ST4_20_OPR3,  ST4_2H_OPR3,  ST4_40_OPR3,  ST4_4H_OPR3,  ST4_45_OPR3," ).append("\n"); 
		query.append("       ST5_20_OPR3,  ST5_2H_OPR3,  ST5_40_OPR3,  ST5_4H_OPR3,  ST5_45_OPR3,  ST6_20_OPR3,  ST6_2H_OPR3,  ST6_40_OPR3,  ST6_4H_OPR3,  ST6_45_OPR3," ).append("\n"); 
		query.append("       ST7_20_OPR3,  ST7_2H_OPR3,  ST7_40_OPR3,  ST7_4H_OPR3,  ST7_45_OPR3,  ST8_20_OPR3,  ST8_2H_OPR3,  ST8_40_OPR3,  ST8_4H_OPR3,  ST8_45_OPR3," ).append("\n"); 
		query.append("       ST9_20_OPR3,  ST9_2H_OPR3,  ST9_40_OPR3,  ST9_4H_OPR3,  ST9_45_OPR3,  ST10_20_OPR3, ST10_2H_OPR3, ST10_40_OPR3, ST10_4H_OPR3, ST10_45_OPR3," ).append("\n"); 
		query.append("       ST11_20_OPR3, ST11_2H_OPR3, ST11_40_OPR3, ST11_4H_OPR3, ST11_45_OPR3, ST12_20_OPR3, ST12_2H_OPR3, ST12_40_OPR3, ST12_4H_OPR3, ST12_45_OPR3," ).append("\n"); 
		query.append("       ST13_20_OPR3, ST13_2H_OPR3, ST13_40_OPR3, ST13_4H_OPR3, ST13_45_OPR3, ST14_20_OPR3, ST14_2H_OPR3, ST14_40_OPR3, ST14_4H_OPR3, ST14_45_OPR3," ).append("\n"); 
		query.append("       ST15_20_OPR3, ST15_2H_OPR3, ST15_40_OPR3, ST15_4H_OPR3, ST15_45_OPR3" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${qty4} != '')" ).append("\n"); 
		query.append("       ,OPR4," ).append("\n"); 
		query.append("       ST1_20_OPR4,  ST1_2H_OPR4,  ST1_40_OPR4,  ST1_4H_OPR4,  ST1_45_OPR4,  ST2_20_OPR4,  ST2_2H_OPR4,  ST2_40_OPR4,  ST2_4H_OPR4,  ST2_45_OPR4," ).append("\n"); 
		query.append("       ST3_20_OPR4,  ST3_2H_OPR4,  ST3_40_OPR4,  ST3_4H_OPR4,  ST3_45_OPR4,  ST4_20_OPR4,  ST4_2H_OPR4,  ST4_40_OPR4,  ST4_4H_OPR4,  ST4_45_OPR4," ).append("\n"); 
		query.append("       ST5_20_OPR4,  ST5_2H_OPR4,  ST5_40_OPR4,  ST5_4H_OPR4,  ST5_45_OPR4,  ST6_20_OPR4,  ST6_2H_OPR4,  ST6_40_OPR4,  ST6_4H_OPR4,  ST6_45_OPR4," ).append("\n"); 
		query.append("       ST7_20_OPR4,  ST7_2H_OPR4,  ST7_40_OPR4,  ST7_4H_OPR4,  ST7_45_OPR4,  ST8_20_OPR4,  ST8_2H_OPR4,  ST8_40_OPR4,  ST8_4H_OPR4,  ST8_45_OPR4," ).append("\n"); 
		query.append("       ST9_20_OPR4,  ST9_2H_OPR4,  ST9_40_OPR4,  ST9_4H_OPR4,  ST9_45_OPR4,  ST10_20_OPR4, ST10_2H_OPR4, ST10_40_OPR4, ST10_4H_OPR4, ST10_45_OPR4," ).append("\n"); 
		query.append("       ST11_20_OPR4, ST11_2H_OPR4, ST11_40_OPR4, ST11_4H_OPR4, ST11_45_OPR4, ST12_20_OPR4, ST12_2H_OPR4, ST12_40_OPR4, ST12_4H_OPR4, ST12_45_OPR4," ).append("\n"); 
		query.append("       ST13_20_OPR4, ST13_2H_OPR4, ST13_40_OPR4, ST13_4H_OPR4, ST13_45_OPR4, ST14_20_OPR4, ST14_2H_OPR4, ST14_40_OPR4, ST14_4H_OPR4, ST14_45_OPR4," ).append("\n"); 
		query.append("       ST15_20_OPR4, ST15_2H_OPR4, ST15_40_OPR4, ST15_4H_OPR4, ST15_45_OPR4" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${qty5} != '')" ).append("\n"); 
		query.append("       ,OPR5," ).append("\n"); 
		query.append("       ST1_20_OPR5,  ST1_2H_OPR5,  ST1_40_OPR5,  ST1_4H_OPR5,  ST1_45_OPR5,  ST2_20_OPR5,  ST2_2H_OPR5,  ST2_40_OPR5,  ST2_4H_OPR5,  ST2_45_OPR5," ).append("\n"); 
		query.append("       ST3_20_OPR5,  ST3_2H_OPR5,  ST3_40_OPR5,  ST3_4H_OPR5,  ST3_45_OPR5,  ST4_20_OPR5,  ST4_2H_OPR5,  ST4_40_OPR5,  ST4_4H_OPR5,  ST4_45_OPR5," ).append("\n"); 
		query.append("       ST5_20_OPR5,  ST5_2H_OPR5,  ST5_40_OPR5,  ST5_4H_OPR5,  ST5_45_OPR5,  ST6_20_OPR5,  ST6_2H_OPR5,  ST6_40_OPR5,  ST6_4H_OPR5,  ST6_45_OPR5," ).append("\n"); 
		query.append("       ST7_20_OPR5,  ST7_2H_OPR5,  ST7_40_OPR5,  ST7_4H_OPR5,  ST7_45_OPR5,  ST8_20_OPR5,  ST8_2H_OPR5,  ST8_40_OPR5,  ST8_4H_OPR5,  ST8_45_OPR5," ).append("\n"); 
		query.append("       ST9_20_OPR5,  ST9_2H_OPR5,  ST9_40_OPR5,  ST9_4H_OPR5,  ST9_45_OPR5,  ST10_20_OPR5, ST10_2H_OPR5, ST10_40_OPR5, ST10_4H_OPR5, ST10_45_OPR5," ).append("\n"); 
		query.append("       ST11_20_OPR5, ST11_2H_OPR5, ST11_40_OPR5, ST11_4H_OPR5, ST11_45_OPR5, ST12_20_OPR5, ST12_2H_OPR5, ST12_40_OPR5, ST12_4H_OPR5, ST12_45_OPR5," ).append("\n"); 
		query.append("       ST13_20_OPR5, ST13_2H_OPR5, ST13_40_OPR5, ST13_4H_OPR5, ST13_45_OPR5, ST14_20_OPR5, ST14_2H_OPR5, ST14_40_OPR5, ST14_4H_OPR5, ST14_45_OPR5," ).append("\n"); 
		query.append("       ST15_20_OPR5, ST15_2H_OPR5, ST15_40_OPR5, ST15_4H_OPR5, ST15_45_OPR5" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM ( SELECT CASE " ).append("\n"); 
		query.append("              WHEN P=1 AND M=1 THEN 'G.Total'" ).append("\n"); 
		query.append("              ELSE POD" ).append("\n"); 
		query.append("              END  POD," ).append("\n"); 
		query.append("              CASE " ).append("\n"); 
		query.append("              WHEN P=0 AND M=1 THEN 'S.Total'" ).append("\n"); 
		query.append("              ELSE MLB" ).append("\n"); 
		query.append("              END  MLB," ).append("\n"); 
		query.append("              OPR1," ).append("\n"); 
		query.append("              ST1_20_OPR1,  ST1_2H_OPR1,  ST1_40_OPR1,  ST1_4H_OPR1,  ST1_45_OPR1,  ST2_20_OPR1,  ST2_2H_OPR1,  ST2_40_OPR1,  ST2_4H_OPR1,  ST2_45_OPR1," ).append("\n"); 
		query.append("              ST3_20_OPR1,  ST3_2H_OPR1,  ST3_40_OPR1,  ST3_4H_OPR1,  ST3_45_OPR1,  ST4_20_OPR1,  ST4_2H_OPR1,  ST4_40_OPR1,  ST4_4H_OPR1,  ST4_45_OPR1," ).append("\n"); 
		query.append("              ST5_20_OPR1,  ST5_2H_OPR1,  ST5_40_OPR1,  ST5_4H_OPR1,  ST5_45_OPR1,  ST6_20_OPR1,  ST6_2H_OPR1,  ST6_40_OPR1,  ST6_4H_OPR1,  ST6_45_OPR1," ).append("\n"); 
		query.append("              ST7_20_OPR1,  ST7_2H_OPR1,  ST7_40_OPR1,  ST7_4H_OPR1,  ST7_45_OPR1,  ST8_20_OPR1,  ST8_2H_OPR1,  ST8_40_OPR1,  ST8_4H_OPR1,  ST8_45_OPR1," ).append("\n"); 
		query.append("              ST9_20_OPR1,  ST9_2H_OPR1,  ST9_40_OPR1,  ST9_4H_OPR1,  ST9_45_OPR1,  ST10_20_OPR1, ST10_2H_OPR1, ST10_40_OPR1, ST10_4H_OPR1, ST10_45_OPR1," ).append("\n"); 
		query.append("              ST11_20_OPR1, ST11_2H_OPR1, ST11_40_OPR1, ST11_4H_OPR1, ST11_45_OPR1, ST12_20_OPR1, ST12_2H_OPR1, ST12_40_OPR1, ST12_4H_OPR1, ST12_45_OPR1," ).append("\n"); 
		query.append("              ST13_20_OPR1, ST13_2H_OPR1, ST13_40_OPR1, ST13_4H_OPR1, ST13_45_OPR1, ST14_20_OPR1, ST14_2H_OPR1, ST14_40_OPR1, ST14_4H_OPR1, ST14_45_OPR1," ).append("\n"); 
		query.append("              ST15_20_OPR1, ST15_2H_OPR1, ST15_40_OPR1, ST15_4H_OPR1, ST15_45_OPR1," ).append("\n"); 
		query.append("              OPR2," ).append("\n"); 
		query.append("              ST1_20_OPR2,  ST1_2H_OPR2,  ST1_40_OPR2,  ST1_4H_OPR2,  ST1_45_OPR2,  ST2_20_OPR2,  ST2_2H_OPR2,  ST2_40_OPR2,  ST2_4H_OPR2,  ST2_45_OPR2," ).append("\n"); 
		query.append("              ST3_20_OPR2,  ST3_2H_OPR2,  ST3_40_OPR2,  ST3_4H_OPR2,  ST3_45_OPR2,  ST4_20_OPR2,  ST4_2H_OPR2,  ST4_40_OPR2,  ST4_4H_OPR2,  ST4_45_OPR2," ).append("\n"); 
		query.append("              ST5_20_OPR2,  ST5_2H_OPR2,  ST5_40_OPR2,  ST5_4H_OPR2,  ST5_45_OPR2,  ST6_20_OPR2,  ST6_2H_OPR2,  ST6_40_OPR2,  ST6_4H_OPR2,  ST6_45_OPR2," ).append("\n"); 
		query.append("              ST7_20_OPR2,  ST7_2H_OPR2,  ST7_40_OPR2,  ST7_4H_OPR2,  ST7_45_OPR2,  ST8_20_OPR2,  ST8_2H_OPR2,  ST8_40_OPR2,  ST8_4H_OPR2,  ST8_45_OPR2," ).append("\n"); 
		query.append("              ST9_20_OPR2,  ST9_2H_OPR2,  ST9_40_OPR2,  ST9_4H_OPR2,  ST9_45_OPR2,  ST10_20_OPR2, ST10_2H_OPR2, ST10_40_OPR2, ST10_4H_OPR2, ST10_45_OPR2," ).append("\n"); 
		query.append("              ST11_20_OPR2, ST11_2H_OPR2, ST11_40_OPR2, ST11_4H_OPR2, ST11_45_OPR2, ST12_20_OPR2, ST12_2H_OPR2, ST12_40_OPR2, ST12_4H_OPR2, ST12_45_OPR2," ).append("\n"); 
		query.append("              ST13_20_OPR2, ST13_2H_OPR2, ST13_40_OPR2, ST13_4H_OPR2, ST13_45_OPR2, ST14_20_OPR2, ST14_2H_OPR2, ST14_40_OPR2, ST14_4H_OPR2, ST14_45_OPR2," ).append("\n"); 
		query.append("              ST15_20_OPR2, ST15_2H_OPR2, ST15_40_OPR2, ST15_4H_OPR2, ST15_45_OPR2," ).append("\n"); 
		query.append("              OPR3," ).append("\n"); 
		query.append("              ST1_20_OPR3,  ST1_2H_OPR3,  ST1_40_OPR3,  ST1_4H_OPR3,  ST1_45_OPR3,  ST2_20_OPR3,  ST2_2H_OPR3,  ST2_40_OPR3,  ST2_4H_OPR3,  ST2_45_OPR3," ).append("\n"); 
		query.append("              ST3_20_OPR3,  ST3_2H_OPR3,  ST3_40_OPR3,  ST3_4H_OPR3,  ST3_45_OPR3,  ST4_20_OPR3,  ST4_2H_OPR3,  ST4_40_OPR3,  ST4_4H_OPR3,  ST4_45_OPR3," ).append("\n"); 
		query.append("              ST5_20_OPR3,  ST5_2H_OPR3,  ST5_40_OPR3,  ST5_4H_OPR3,  ST5_45_OPR3,  ST6_20_OPR3,  ST6_2H_OPR3,  ST6_40_OPR3,  ST6_4H_OPR3,  ST6_45_OPR3," ).append("\n"); 
		query.append("              ST7_20_OPR3,  ST7_2H_OPR3,  ST7_40_OPR3,  ST7_4H_OPR3,  ST7_45_OPR3,  ST8_20_OPR3,  ST8_2H_OPR3,  ST8_40_OPR3,  ST8_4H_OPR3,  ST8_45_OPR3," ).append("\n"); 
		query.append("              ST9_20_OPR3,  ST9_2H_OPR3,  ST9_40_OPR3,  ST9_4H_OPR3,  ST9_45_OPR3,  ST10_20_OPR3, ST10_2H_OPR3, ST10_40_OPR3, ST10_4H_OPR3, ST10_45_OPR3," ).append("\n"); 
		query.append("              ST11_20_OPR3, ST11_2H_OPR3, ST11_40_OPR3, ST11_4H_OPR3, ST11_45_OPR3, ST12_20_OPR3, ST12_2H_OPR3, ST12_40_OPR3, ST12_4H_OPR3, ST12_45_OPR3," ).append("\n"); 
		query.append("              ST13_20_OPR3, ST13_2H_OPR3, ST13_40_OPR3, ST13_4H_OPR3, ST13_45_OPR3, ST14_20_OPR3, ST14_2H_OPR3, ST14_40_OPR3, ST14_4H_OPR3, ST14_45_OPR3," ).append("\n"); 
		query.append("              ST15_20_OPR3, ST15_2H_OPR3, ST15_40_OPR3, ST15_4H_OPR3, ST15_45_OPR3," ).append("\n"); 
		query.append("              OPR4," ).append("\n"); 
		query.append("              ST1_20_OPR4,  ST1_2H_OPR4,  ST1_40_OPR4,  ST1_4H_OPR4,  ST1_45_OPR4,  ST2_20_OPR4,  ST2_2H_OPR4,  ST2_40_OPR4,  ST2_4H_OPR4,  ST2_45_OPR4," ).append("\n"); 
		query.append("              ST3_20_OPR4,  ST3_2H_OPR4,  ST3_40_OPR4,  ST3_4H_OPR4,  ST3_45_OPR4,  ST4_20_OPR4,  ST4_2H_OPR4,  ST4_40_OPR4,  ST4_4H_OPR4,  ST4_45_OPR4," ).append("\n"); 
		query.append("              ST5_20_OPR4,  ST5_2H_OPR4,  ST5_40_OPR4,  ST5_4H_OPR4,  ST5_45_OPR4,  ST6_20_OPR4,  ST6_2H_OPR4,  ST6_40_OPR4,  ST6_4H_OPR4,  ST6_45_OPR4," ).append("\n"); 
		query.append("              ST7_20_OPR4,  ST7_2H_OPR4,  ST7_40_OPR4,  ST7_4H_OPR4,  ST7_45_OPR4,  ST8_20_OPR4,  ST8_2H_OPR4,  ST8_40_OPR4,  ST8_4H_OPR4,  ST8_45_OPR4," ).append("\n"); 
		query.append("              ST9_20_OPR4,  ST9_2H_OPR4,  ST9_40_OPR4,  ST9_4H_OPR4,  ST9_45_OPR4,  ST10_20_OPR4, ST10_2H_OPR4, ST10_40_OPR4, ST10_4H_OPR4, ST10_45_OPR4," ).append("\n"); 
		query.append("              ST11_20_OPR4, ST11_2H_OPR4, ST11_40_OPR4, ST11_4H_OPR4, ST11_45_OPR4, ST12_20_OPR4, ST12_2H_OPR4, ST12_40_OPR4, ST12_4H_OPR4, ST12_45_OPR4," ).append("\n"); 
		query.append("              ST13_20_OPR4, ST13_2H_OPR4, ST13_40_OPR4, ST13_4H_OPR4, ST13_45_OPR4, ST14_20_OPR4, ST14_2H_OPR4, ST14_40_OPR4, ST14_4H_OPR4, ST14_45_OPR4," ).append("\n"); 
		query.append("              ST15_20_OPR4, ST15_2H_OPR4, ST15_40_OPR4, ST15_4H_OPR4, ST15_45_OPR4," ).append("\n"); 
		query.append("              OPR5," ).append("\n"); 
		query.append("              ST1_20_OPR5,  ST1_2H_OPR5,  ST1_40_OPR5,  ST1_4H_OPR5,  ST1_45_OPR5,  ST2_20_OPR5,  ST2_2H_OPR5,  ST2_40_OPR5,  ST2_4H_OPR5,  ST2_45_OPR5," ).append("\n"); 
		query.append("              ST3_20_OPR5,  ST3_2H_OPR5,  ST3_40_OPR5,  ST3_4H_OPR5,  ST3_45_OPR5,  ST4_20_OPR5,  ST4_2H_OPR5,  ST4_40_OPR5,  ST4_4H_OPR5,  ST4_45_OPR5," ).append("\n"); 
		query.append("              ST5_20_OPR5,  ST5_2H_OPR5,  ST5_40_OPR5,  ST5_4H_OPR5,  ST5_45_OPR5,  ST6_20_OPR5,  ST6_2H_OPR5,  ST6_40_OPR5,  ST6_4H_OPR5,  ST6_45_OPR5," ).append("\n"); 
		query.append("              ST7_20_OPR5,  ST7_2H_OPR5,  ST7_40_OPR5,  ST7_4H_OPR5,  ST7_45_OPR5,  ST8_20_OPR5,  ST8_2H_OPR5,  ST8_40_OPR5,  ST8_4H_OPR5,  ST8_45_OPR5," ).append("\n"); 
		query.append("              ST9_20_OPR5,  ST9_2H_OPR5,  ST9_40_OPR5,  ST9_4H_OPR5,  ST9_45_OPR5,  ST10_20_OPR5, ST10_2H_OPR5, ST10_40_OPR5, ST10_4H_OPR5, ST10_45_OPR5," ).append("\n"); 
		query.append("              ST11_20_OPR5, ST11_2H_OPR5, ST11_40_OPR5, ST11_4H_OPR5, ST11_45_OPR5, ST12_20_OPR5, ST12_2H_OPR5, ST12_40_OPR5, ST12_4H_OPR5, ST12_45_OPR5," ).append("\n"); 
		query.append("              ST13_20_OPR5, ST13_2H_OPR5, ST13_40_OPR5, ST13_4H_OPR5, ST13_45_OPR5, ST14_20_OPR5, ST14_2H_OPR5, ST14_40_OPR5, ST14_4H_OPR5, ST14_45_OPR5," ).append("\n"); 
		query.append("              ST15_20_OPR5, ST15_2H_OPR5, ST15_40_OPR5, ST15_4H_OPR5, ST15_45_OPR5," ).append("\n"); 
		query.append("              P.SEQ" ).append("\n"); 
		query.append("       FROM   ( SELECT (POD||POD_CLPT_IND_SEQ) AS POD, MLB," ).append("\n"); 
		query.append("                       GROUPING(POD||POD_CLPT_IND_SEQ) P, GROUPING(MLB) M," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ)=0 AND GROUPING(MLB)=1 THEN 1" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ)=0 AND GROUPING(MLB)=0 THEN 1" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ)=0 AND GROUPING(MLB)=1 THEN 1" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ)=1 AND GROUPING(MLB)=1 THEN 1" ).append("\n"); 
		query.append("                       ELSE 0" ).append("\n"); 
		query.append("                       END C2," ).append("\n"); 
		query.append("                       MAX(OPR1) OPR1," ).append("\n"); 
		query.append("                       SUM(ST1_20_OPR1)  ST1_20_OPR1,  SUM(ST1_2H_OPR1)  ST1_2H_OPR1,  SUM(ST1_40_OPR1)  ST1_40_OPR1,  SUM(ST1_4H_OPR1)  ST1_4H_OPR1,  SUM(ST1_45_OPR1)  ST1_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST2_20_OPR1)  ST2_20_OPR1,  SUM(ST2_2H_OPR1)  ST2_2H_OPR1,  SUM(ST2_40_OPR1)  ST2_40_OPR1,  SUM(ST2_4H_OPR1)  ST2_4H_OPR1,  SUM(ST2_45_OPR1)  ST2_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST3_20_OPR1)  ST3_20_OPR1,  SUM(ST3_2H_OPR1)  ST3_2H_OPR1,  SUM(ST3_40_OPR1)  ST3_40_OPR1,  SUM(ST3_4H_OPR1)  ST3_4H_OPR1,  SUM(ST3_45_OPR1)  ST3_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST4_20_OPR1)  ST4_20_OPR1,  SUM(ST4_2H_OPR1)  ST4_2H_OPR1,  SUM(ST4_40_OPR1)  ST4_40_OPR1,  SUM(ST4_4H_OPR1)  ST4_4H_OPR1,  SUM(ST4_45_OPR1)  ST4_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST5_20_OPR1)  ST5_20_OPR1,  SUM(ST5_2H_OPR1)  ST5_2H_OPR1,  SUM(ST5_40_OPR1)  ST5_40_OPR1,  SUM(ST5_4H_OPR1)  ST5_4H_OPR1,  SUM(ST5_45_OPR1)  ST5_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST6_20_OPR1)  ST6_20_OPR1,  SUM(ST6_2H_OPR1)  ST6_2H_OPR1,  SUM(ST6_40_OPR1)  ST6_40_OPR1,  SUM(ST6_4H_OPR1)  ST6_4H_OPR1,  SUM(ST6_45_OPR1)  ST6_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST7_20_OPR1)  ST7_20_OPR1,  SUM(ST7_2H_OPR1)  ST7_2H_OPR1,  SUM(ST7_40_OPR1)  ST7_40_OPR1,  SUM(ST7_4H_OPR1)  ST7_4H_OPR1,  SUM(ST7_45_OPR1)  ST7_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST8_20_OPR1)  ST8_20_OPR1,  SUM(ST8_2H_OPR1)  ST8_2H_OPR1,  SUM(ST8_40_OPR1)  ST8_40_OPR1,  SUM(ST8_4H_OPR1)  ST8_4H_OPR1,  SUM(ST8_45_OPR1)  ST8_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST9_20_OPR1)  ST9_20_OPR1,  SUM(ST9_2H_OPR1)  ST9_2H_OPR1,  SUM(ST9_40_OPR1)  ST9_40_OPR1,  SUM(ST9_4H_OPR1)  ST9_4H_OPR1,  SUM(ST9_45_OPR1)  ST9_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST10_20_OPR1) ST10_20_OPR1, SUM(ST10_2H_OPR1) ST10_2H_OPR1, SUM(ST10_40_OPR1) ST10_40_OPR1, SUM(ST10_4H_OPR1) ST10_4H_OPR1, SUM(ST10_45_OPR1) ST10_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST11_20_OPR1) ST11_20_OPR1, SUM(ST11_2H_OPR1) ST11_2H_OPR1, SUM(ST11_40_OPR1) ST11_40_OPR1, SUM(ST11_4H_OPR1) ST11_4H_OPR1, SUM(ST11_45_OPR1) ST11_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST12_20_OPR1) ST12_20_OPR1, SUM(ST12_2H_OPR1) ST12_2H_OPR1, SUM(ST12_40_OPR1) ST12_40_OPR1, SUM(ST12_4H_OPR1) ST12_4H_OPR1, SUM(ST12_45_OPR1) ST12_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST13_20_OPR1) ST13_20_OPR1, SUM(ST13_2H_OPR1) ST13_2H_OPR1, SUM(ST13_40_OPR1) ST13_40_OPR1, SUM(ST13_4H_OPR1) ST13_4H_OPR1, SUM(ST13_45_OPR1) ST13_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST14_20_OPR1) ST14_20_OPR1, SUM(ST14_2H_OPR1) ST14_2H_OPR1, SUM(ST14_40_OPR1) ST14_40_OPR1, SUM(ST14_4H_OPR1) ST14_4H_OPR1, SUM(ST14_45_OPR1) ST14_45_OPR1," ).append("\n"); 
		query.append("                       SUM(ST15_20_OPR1) ST15_20_OPR1, SUM(ST15_2H_OPR1) ST15_2H_OPR1, SUM(ST15_40_OPR1) ST15_40_OPR1, SUM(ST15_4H_OPR1) ST15_4H_OPR1, SUM(ST15_45_OPR1) ST15_45_OPR1," ).append("\n"); 
		query.append("                       MAX(OPR2) OPR2," ).append("\n"); 
		query.append("                       SUM(ST1_20_OPR2)  ST1_20_OPR2,  SUM(ST1_2H_OPR2)  ST1_2H_OPR2,  SUM(ST1_40_OPR2)  ST1_40_OPR2,  SUM(ST1_4H_OPR2)  ST1_4H_OPR2,  SUM(ST1_45_OPR2)  ST1_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST2_20_OPR2)  ST2_20_OPR2,  SUM(ST2_2H_OPR2)  ST2_2H_OPR2,  SUM(ST2_40_OPR2)  ST2_40_OPR2,  SUM(ST2_4H_OPR2)  ST2_4H_OPR2,  SUM(ST2_45_OPR2)  ST2_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST3_20_OPR2)  ST3_20_OPR2,  SUM(ST3_2H_OPR2)  ST3_2H_OPR2,  SUM(ST3_40_OPR2)  ST3_40_OPR2,  SUM(ST3_4H_OPR2)  ST3_4H_OPR2,  SUM(ST3_45_OPR2)  ST3_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST4_20_OPR2)  ST4_20_OPR2,  SUM(ST4_2H_OPR2)  ST4_2H_OPR2,  SUM(ST4_40_OPR2)  ST4_40_OPR2,  SUM(ST4_4H_OPR2)  ST4_4H_OPR2,  SUM(ST4_45_OPR2)  ST4_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST5_20_OPR2)  ST5_20_OPR2,  SUM(ST5_2H_OPR2)  ST5_2H_OPR2,  SUM(ST5_40_OPR2)  ST5_40_OPR2,  SUM(ST5_4H_OPR2)  ST5_4H_OPR2,  SUM(ST5_45_OPR2)  ST5_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST6_20_OPR2)  ST6_20_OPR2,  SUM(ST6_2H_OPR2)  ST6_2H_OPR2,  SUM(ST6_40_OPR2)  ST6_40_OPR2,  SUM(ST6_4H_OPR2)  ST6_4H_OPR2,  SUM(ST6_45_OPR2)  ST6_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST7_20_OPR2)  ST7_20_OPR2,  SUM(ST7_2H_OPR2)  ST7_2H_OPR2,  SUM(ST7_40_OPR2)  ST7_40_OPR2,  SUM(ST7_4H_OPR2)  ST7_4H_OPR2,  SUM(ST7_45_OPR2)  ST7_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST8_20_OPR2)  ST8_20_OPR2,  SUM(ST8_2H_OPR2)  ST8_2H_OPR2,  SUM(ST8_40_OPR2)  ST8_40_OPR2,  SUM(ST8_4H_OPR2)  ST8_4H_OPR2,  SUM(ST8_45_OPR2)  ST8_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST9_20_OPR2)  ST9_20_OPR2,  SUM(ST9_2H_OPR2)  ST9_2H_OPR2,  SUM(ST9_40_OPR2)  ST9_40_OPR2,  SUM(ST9_4H_OPR2)  ST9_4H_OPR2,  SUM(ST9_45_OPR2)  ST9_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST10_20_OPR2) ST10_20_OPR2, SUM(ST10_2H_OPR2) ST10_2H_OPR2, SUM(ST10_40_OPR2) ST10_40_OPR2, SUM(ST10_4H_OPR2) ST10_4H_OPR2, SUM(ST10_45_OPR2) ST10_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST11_20_OPR2) ST11_20_OPR2, SUM(ST11_2H_OPR2) ST11_2H_OPR2, SUM(ST11_40_OPR2) ST11_40_OPR2, SUM(ST11_4H_OPR2) ST11_4H_OPR2, SUM(ST11_45_OPR2) ST11_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST12_20_OPR2) ST12_20_OPR2, SUM(ST12_2H_OPR2) ST12_2H_OPR2, SUM(ST12_40_OPR2) ST12_40_OPR2, SUM(ST12_4H_OPR2) ST12_4H_OPR2, SUM(ST12_45_OPR2) ST12_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST13_20_OPR2) ST13_20_OPR2, SUM(ST13_2H_OPR2) ST13_2H_OPR2, SUM(ST13_40_OPR2) ST13_40_OPR2, SUM(ST13_4H_OPR2) ST13_4H_OPR2, SUM(ST13_45_OPR2) ST13_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST14_20_OPR2) ST14_20_OPR2, SUM(ST14_2H_OPR2) ST14_2H_OPR2, SUM(ST14_40_OPR2) ST14_40_OPR2, SUM(ST14_4H_OPR2) ST14_4H_OPR2, SUM(ST14_45_OPR2) ST14_45_OPR2," ).append("\n"); 
		query.append("                       SUM(ST15_20_OPR2) ST15_20_OPR2, SUM(ST15_2H_OPR2) ST15_2H_OPR2, SUM(ST15_40_OPR2) ST15_40_OPR2, SUM(ST15_4H_OPR2) ST15_4H_OPR2, SUM(ST15_45_OPR2) ST15_45_OPR2," ).append("\n"); 
		query.append("                       MAX(OPR3) OPR3," ).append("\n"); 
		query.append("                       SUM(ST1_20_OPR3)  ST1_20_OPR3,  SUM(ST1_2H_OPR3)  ST1_2H_OPR3,  SUM(ST1_40_OPR3)  ST1_40_OPR3,  SUM(ST1_4H_OPR3)  ST1_4H_OPR3,  SUM(ST1_45_OPR3)  ST1_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST2_20_OPR3)  ST2_20_OPR3,  SUM(ST2_2H_OPR3)  ST2_2H_OPR3,  SUM(ST2_40_OPR3)  ST2_40_OPR3,  SUM(ST2_4H_OPR3)  ST2_4H_OPR3,  SUM(ST2_45_OPR3)  ST2_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST3_20_OPR3)  ST3_20_OPR3,  SUM(ST3_2H_OPR3)  ST3_2H_OPR3,  SUM(ST3_40_OPR3)  ST3_40_OPR3,  SUM(ST3_4H_OPR3)  ST3_4H_OPR3,  SUM(ST3_45_OPR3)  ST3_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST4_20_OPR3)  ST4_20_OPR3,  SUM(ST4_2H_OPR3)  ST4_2H_OPR3,  SUM(ST4_40_OPR3)  ST4_40_OPR3,  SUM(ST4_4H_OPR3)  ST4_4H_OPR3,  SUM(ST4_45_OPR3)  ST4_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST5_20_OPR3)  ST5_20_OPR3,  SUM(ST5_2H_OPR3)  ST5_2H_OPR3,  SUM(ST5_40_OPR3)  ST5_40_OPR3,  SUM(ST5_4H_OPR3)  ST5_4H_OPR3,  SUM(ST5_45_OPR3)  ST5_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST6_20_OPR3)  ST6_20_OPR3,  SUM(ST6_2H_OPR3)  ST6_2H_OPR3,  SUM(ST6_40_OPR3)  ST6_40_OPR3,  SUM(ST6_4H_OPR3)  ST6_4H_OPR3,  SUM(ST6_45_OPR3)  ST6_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST7_20_OPR3)  ST7_20_OPR3,  SUM(ST7_2H_OPR3)  ST7_2H_OPR3,  SUM(ST7_40_OPR3)  ST7_40_OPR3,  SUM(ST7_4H_OPR3)  ST7_4H_OPR3,  SUM(ST7_45_OPR3)  ST7_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST8_20_OPR3)  ST8_20_OPR3,  SUM(ST8_2H_OPR3)  ST8_2H_OPR3,  SUM(ST8_40_OPR3)  ST8_40_OPR3,  SUM(ST8_4H_OPR3)  ST8_4H_OPR3,  SUM(ST8_45_OPR3)  ST8_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST9_20_OPR3)  ST9_20_OPR3,  SUM(ST9_2H_OPR3)  ST9_2H_OPR3,  SUM(ST9_40_OPR3)  ST9_40_OPR3,  SUM(ST9_4H_OPR3)  ST9_4H_OPR3,  SUM(ST9_45_OPR3)  ST9_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST10_20_OPR3) ST10_20_OPR3, SUM(ST10_2H_OPR3) ST10_2H_OPR3, SUM(ST10_40_OPR3) ST10_40_OPR3, SUM(ST10_4H_OPR3) ST10_4H_OPR3, SUM(ST10_45_OPR3) ST10_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST11_20_OPR3) ST11_20_OPR3, SUM(ST11_2H_OPR3) ST11_2H_OPR3, SUM(ST11_40_OPR3) ST11_40_OPR3, SUM(ST11_4H_OPR3) ST11_4H_OPR3, SUM(ST11_45_OPR3) ST11_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST12_20_OPR3) ST12_20_OPR3, SUM(ST12_2H_OPR3) ST12_2H_OPR3, SUM(ST12_40_OPR3) ST12_40_OPR3, SUM(ST12_4H_OPR3) ST12_4H_OPR3, SUM(ST12_45_OPR3) ST12_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST13_20_OPR3) ST13_20_OPR3, SUM(ST13_2H_OPR3) ST13_2H_OPR3, SUM(ST13_40_OPR3) ST13_40_OPR3, SUM(ST13_4H_OPR3) ST13_4H_OPR3, SUM(ST13_45_OPR3) ST13_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST14_20_OPR3) ST14_20_OPR3, SUM(ST14_2H_OPR3) ST14_2H_OPR3, SUM(ST14_40_OPR3) ST14_40_OPR3, SUM(ST14_4H_OPR3) ST14_4H_OPR3, SUM(ST14_45_OPR3) ST14_45_OPR3," ).append("\n"); 
		query.append("                       SUM(ST15_20_OPR3) ST15_20_OPR3, SUM(ST15_2H_OPR3) ST15_2H_OPR3, SUM(ST15_40_OPR3) ST15_40_OPR3, SUM(ST15_4H_OPR3) ST15_4H_OPR3, SUM(ST15_45_OPR3) ST15_45_OPR3," ).append("\n"); 
		query.append("                       MAX(OPR4) OPR4," ).append("\n"); 
		query.append("                       SUM(ST1_20_OPR4)  ST1_20_OPR4,  SUM(ST1_2H_OPR4)  ST1_2H_OPR4,  SUM(ST1_40_OPR4)  ST1_40_OPR4,  SUM(ST1_4H_OPR4)  ST1_4H_OPR4,  SUM(ST1_45_OPR4)  ST1_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST2_20_OPR4)  ST2_20_OPR4,  SUM(ST2_2H_OPR4)  ST2_2H_OPR4,  SUM(ST2_40_OPR4)  ST2_40_OPR4,  SUM(ST2_4H_OPR4)  ST2_4H_OPR4,  SUM(ST2_45_OPR4)  ST2_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST3_20_OPR4)  ST3_20_OPR4,  SUM(ST3_2H_OPR4)  ST3_2H_OPR4,  SUM(ST3_40_OPR4)  ST3_40_OPR4,  SUM(ST3_4H_OPR4)  ST3_4H_OPR4,  SUM(ST3_45_OPR4)  ST3_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST4_20_OPR4)  ST4_20_OPR4,  SUM(ST4_2H_OPR4)  ST4_2H_OPR4,  SUM(ST4_40_OPR4)  ST4_40_OPR4,  SUM(ST4_4H_OPR4)  ST4_4H_OPR4,  SUM(ST4_45_OPR4)  ST4_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST5_20_OPR4)  ST5_20_OPR4,  SUM(ST5_2H_OPR4)  ST5_2H_OPR4,  SUM(ST5_40_OPR4)  ST5_40_OPR4,  SUM(ST5_4H_OPR4)  ST5_4H_OPR4,  SUM(ST5_45_OPR4)  ST5_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST6_20_OPR4)  ST6_20_OPR4,  SUM(ST6_2H_OPR4)  ST6_2H_OPR4,  SUM(ST6_40_OPR4)  ST6_40_OPR4,  SUM(ST6_4H_OPR4)  ST6_4H_OPR4,  SUM(ST6_45_OPR4)  ST6_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST7_20_OPR4)  ST7_20_OPR4,  SUM(ST7_2H_OPR4)  ST7_2H_OPR4,  SUM(ST7_40_OPR4)  ST7_40_OPR4,  SUM(ST7_4H_OPR4)  ST7_4H_OPR4,  SUM(ST7_45_OPR4)  ST7_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST8_20_OPR4)  ST8_20_OPR4,  SUM(ST8_2H_OPR4)  ST8_2H_OPR4,  SUM(ST8_40_OPR4)  ST8_40_OPR4,  SUM(ST8_4H_OPR4)  ST8_4H_OPR4,  SUM(ST8_45_OPR4)  ST8_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST9_20_OPR4)  ST9_20_OPR4,  SUM(ST9_2H_OPR4)  ST9_2H_OPR4,  SUM(ST9_40_OPR4)  ST9_40_OPR4,  SUM(ST9_4H_OPR4)  ST9_4H_OPR4,  SUM(ST9_45_OPR4)  ST9_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST10_20_OPR4) ST10_20_OPR4, SUM(ST10_2H_OPR4) ST10_2H_OPR4, SUM(ST10_40_OPR4) ST10_40_OPR4, SUM(ST10_4H_OPR4) ST10_4H_OPR4, SUM(ST10_45_OPR4) ST10_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST11_20_OPR4) ST11_20_OPR4, SUM(ST11_2H_OPR4) ST11_2H_OPR4, SUM(ST11_40_OPR4) ST11_40_OPR4, SUM(ST11_4H_OPR4) ST11_4H_OPR4, SUM(ST11_45_OPR4) ST11_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST12_20_OPR4) ST12_20_OPR4, SUM(ST12_2H_OPR4) ST12_2H_OPR4, SUM(ST12_40_OPR4) ST12_40_OPR4, SUM(ST12_4H_OPR4) ST12_4H_OPR4, SUM(ST12_45_OPR4) ST12_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST13_20_OPR4) ST13_20_OPR4, SUM(ST13_2H_OPR4) ST13_2H_OPR4, SUM(ST13_40_OPR4) ST13_40_OPR4, SUM(ST13_4H_OPR4) ST13_4H_OPR4, SUM(ST13_45_OPR4) ST13_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST14_20_OPR4) ST14_20_OPR4, SUM(ST14_2H_OPR4) ST14_2H_OPR4, SUM(ST14_40_OPR4) ST14_40_OPR4, SUM(ST14_4H_OPR4) ST14_4H_OPR4, SUM(ST14_45_OPR4) ST14_45_OPR4," ).append("\n"); 
		query.append("                       SUM(ST15_20_OPR4) ST15_20_OPR4, SUM(ST15_2H_OPR4) ST15_2H_OPR4, SUM(ST15_40_OPR4) ST15_40_OPR4, SUM(ST15_4H_OPR4) ST15_4H_OPR4, SUM(ST15_45_OPR4) ST15_45_OPR4," ).append("\n"); 
		query.append("                       MAX(OPR5) OPR5," ).append("\n"); 
		query.append("                       SUM(ST1_20_OPR5)  ST1_20_OPR5,  SUM(ST1_2H_OPR5)  ST1_2H_OPR5,  SUM(ST1_40_OPR5)  ST1_40_OPR5,  SUM(ST1_4H_OPR5)  ST1_4H_OPR5,  SUM(ST1_45_OPR5)  ST1_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST2_20_OPR5)  ST2_20_OPR5,  SUM(ST2_2H_OPR5)  ST2_2H_OPR5,  SUM(ST2_40_OPR5)  ST2_40_OPR5,  SUM(ST2_4H_OPR5)  ST2_4H_OPR5,  SUM(ST2_45_OPR5)  ST2_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST3_20_OPR5)  ST3_20_OPR5,  SUM(ST3_2H_OPR5)  ST3_2H_OPR5,  SUM(ST3_40_OPR5)  ST3_40_OPR5,  SUM(ST3_4H_OPR5)  ST3_4H_OPR5,  SUM(ST3_45_OPR5)  ST3_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST4_20_OPR5)  ST4_20_OPR5,  SUM(ST4_2H_OPR5)  ST4_2H_OPR5,  SUM(ST4_40_OPR5)  ST4_40_OPR5,  SUM(ST4_4H_OPR5)  ST4_4H_OPR5,  SUM(ST4_45_OPR5)  ST4_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST5_20_OPR5)  ST5_20_OPR5,  SUM(ST5_2H_OPR5)  ST5_2H_OPR5,  SUM(ST5_40_OPR5)  ST5_40_OPR5,  SUM(ST5_4H_OPR5)  ST5_4H_OPR5,  SUM(ST5_45_OPR5)  ST5_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST6_20_OPR5)  ST6_20_OPR5,  SUM(ST6_2H_OPR5)  ST6_2H_OPR5,  SUM(ST6_40_OPR5)  ST6_40_OPR5,  SUM(ST6_4H_OPR5)  ST6_4H_OPR5,  SUM(ST6_45_OPR5)  ST6_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST7_20_OPR5)  ST7_20_OPR5,  SUM(ST7_2H_OPR5)  ST7_2H_OPR5,  SUM(ST7_40_OPR5)  ST7_40_OPR5,  SUM(ST7_4H_OPR5)  ST7_4H_OPR5,  SUM(ST7_45_OPR5)  ST7_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST8_20_OPR5)  ST8_20_OPR5,  SUM(ST8_2H_OPR5)  ST8_2H_OPR5,  SUM(ST8_40_OPR5)  ST8_40_OPR5,  SUM(ST8_4H_OPR5)  ST8_4H_OPR5,  SUM(ST8_45_OPR5)  ST8_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST9_20_OPR5)  ST9_20_OPR5,  SUM(ST9_2H_OPR5)  ST9_2H_OPR5,  SUM(ST9_40_OPR5)  ST9_40_OPR5,  SUM(ST9_4H_OPR5)  ST9_4H_OPR5,  SUM(ST9_45_OPR5)  ST9_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST10_20_OPR5) ST10_20_OPR5, SUM(ST10_2H_OPR5) ST10_2H_OPR5, SUM(ST10_40_OPR5) ST10_40_OPR5, SUM(ST10_4H_OPR5) ST10_4H_OPR5, SUM(ST10_45_OPR5) ST10_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST11_20_OPR5) ST11_20_OPR5, SUM(ST11_2H_OPR5) ST11_2H_OPR5, SUM(ST11_40_OPR5) ST11_40_OPR5, SUM(ST11_4H_OPR5) ST11_4H_OPR5, SUM(ST11_45_OPR5) ST11_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST12_20_OPR5) ST12_20_OPR5, SUM(ST12_2H_OPR5) ST12_2H_OPR5, SUM(ST12_40_OPR5) ST12_40_OPR5, SUM(ST12_4H_OPR5) ST12_4H_OPR5, SUM(ST12_45_OPR5) ST12_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST13_20_OPR5) ST13_20_OPR5, SUM(ST13_2H_OPR5) ST13_2H_OPR5, SUM(ST13_40_OPR5) ST13_40_OPR5, SUM(ST13_4H_OPR5) ST13_4H_OPR5, SUM(ST13_45_OPR5) ST13_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST14_20_OPR5) ST14_20_OPR5, SUM(ST14_2H_OPR5) ST14_2H_OPR5, SUM(ST14_40_OPR5) ST14_40_OPR5, SUM(ST14_4H_OPR5) ST14_4H_OPR5, SUM(ST14_45_OPR5) ST14_45_OPR5," ).append("\n"); 
		query.append("                       SUM(ST15_20_OPR5) ST15_20_OPR5, SUM(ST15_2H_OPR5) ST15_2H_OPR5, SUM(ST15_40_OPR5) ST15_40_OPR5, SUM(ST15_4H_OPR5) ST15_4H_OPR5, SUM(ST15_45_OPR5) ST15_45_OPR5" ).append("\n"); 
		query.append("                FROM ( SELECT POD," ).append("\n"); 
		query.append("                              POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                              MLB," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,OPR,0))   OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST1_20,0)) ST1_20_OPR1, MAX(DECODE(ROW_NUM,1,ST1_2H,0)) ST1_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST1_40,0)) ST1_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST1_4H,0)) ST1_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST1_45,0)) ST1_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST2_20,0)) ST2_20_OPR1, MAX(DECODE(ROW_NUM,1,ST2_2H,0)) ST2_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST2_40,0)) ST2_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST2_4H,0)) ST2_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST2_45,0)) ST2_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST3_20,0)) ST3_20_OPR1, MAX(DECODE(ROW_NUM,1,ST3_2H,0)) ST3_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST3_40,0)) ST3_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST3_4H,0)) ST3_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST3_45,0)) ST3_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST4_20,0)) ST4_20_OPR1, MAX(DECODE(ROW_NUM,1,ST4_2H,0)) ST4_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST4_40,0)) ST4_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST4_4H,0)) ST4_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST4_45,0)) ST4_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST5_20,0)) ST5_20_OPR1, MAX(DECODE(ROW_NUM,1,ST5_2H,0)) ST5_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST5_40,0)) ST5_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST5_4H,0)) ST5_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST5_45,0)) ST5_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST6_20,0)) ST6_20_OPR1, MAX(DECODE(ROW_NUM,1,ST6_2H,0)) ST6_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST6_40,0)) ST6_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST6_4H,0)) ST6_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST6_45,0)) ST6_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST7_20,0)) ST7_20_OPR1, MAX(DECODE(ROW_NUM,1,ST7_2H,0)) ST7_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST7_40,0)) ST7_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST7_4H,0)) ST7_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST7_45,0)) ST7_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST8_20,0)) ST8_20_OPR1, MAX(DECODE(ROW_NUM,1,ST8_2H,0)) ST8_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST8_40,0)) ST8_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST8_4H,0)) ST8_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST8_45,0)) ST8_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST9_20,0)) ST9_20_OPR1, MAX(DECODE(ROW_NUM,1,ST9_2H,0)) ST9_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST9_40,0)) ST9_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST9_4H,0)) ST9_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST9_45,0)) ST9_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST10_20,0)) ST10_20_OPR1, MAX(DECODE(ROW_NUM,1,ST10_2H,0)) ST10_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST10_40,0)) ST10_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST10_4H,0)) ST10_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST10_45,0)) ST10_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST11_20,0)) ST11_20_OPR1, MAX(DECODE(ROW_NUM,1,ST11_2H,0)) ST11_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST11_40,0)) ST11_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST11_4H,0)) ST11_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST11_45,0)) ST11_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST12_20,0)) ST12_20_OPR1, MAX(DECODE(ROW_NUM,1,ST12_2H,0)) ST12_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST12_40,0)) ST12_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST12_4H,0)) ST12_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST12_45,0)) ST12_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST13_20,0)) ST13_20_OPR1, MAX(DECODE(ROW_NUM,1,ST13_2H,0)) ST13_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST13_40,0)) ST13_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST13_4H,0)) ST13_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST13_45,0)) ST13_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST14_20,0)) ST14_20_OPR1, MAX(DECODE(ROW_NUM,1,ST14_2H,0)) ST14_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST14_40,0)) ST14_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST14_4H,0)) ST14_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST14_45,0)) ST14_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST15_20,0)) ST15_20_OPR1, MAX(DECODE(ROW_NUM,1,ST15_2H,0)) ST15_2H_OPR1, MAX(DECODE(ROW_NUM,1,ST15_40,0)) ST15_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,ST15_4H,0)) ST15_4H_OPR1, MAX(DECODE(ROW_NUM,1,ST15_45,0)) ST15_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,OPR,0))   OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST1_20,0)) ST1_20_OPR2, MAX(DECODE(ROW_NUM,2,ST1_2H,0)) ST1_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST1_40,0)) ST1_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST1_4H,0)) ST1_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST1_45,0)) ST1_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST2_20,0)) ST2_20_OPR2, MAX(DECODE(ROW_NUM,2,ST2_2H,0)) ST2_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST2_40,0)) ST2_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST2_4H,0)) ST2_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST2_45,0)) ST2_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST3_20,0)) ST3_20_OPR2, MAX(DECODE(ROW_NUM,2,ST3_2H,0)) ST3_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST3_40,0)) ST3_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST3_4H,0)) ST3_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST3_45,0)) ST3_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST4_20,0)) ST4_20_OPR2, MAX(DECODE(ROW_NUM,2,ST4_2H,0)) ST4_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST4_40,0)) ST4_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST4_4H,0)) ST4_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST4_45,0)) ST4_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST5_20,0)) ST5_20_OPR2, MAX(DECODE(ROW_NUM,2,ST5_2H,0)) ST5_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST5_40,0)) ST5_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST5_4H,0)) ST5_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST5_45,0)) ST5_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST6_20,0)) ST6_20_OPR2, MAX(DECODE(ROW_NUM,2,ST6_2H,0)) ST6_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST6_40,0)) ST6_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST6_4H,0)) ST6_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST6_45,0)) ST6_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST7_20,0)) ST7_20_OPR2, MAX(DECODE(ROW_NUM,2,ST7_2H,0)) ST7_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST7_40,0)) ST7_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST7_4H,0)) ST7_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST7_45,0)) ST7_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST8_20,0)) ST8_20_OPR2, MAX(DECODE(ROW_NUM,2,ST8_2H,0)) ST8_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST8_40,0)) ST8_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST8_4H,0)) ST8_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST8_45,0)) ST8_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST9_20,0)) ST9_20_OPR2, MAX(DECODE(ROW_NUM,2,ST9_2H,0)) ST9_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST9_40,0)) ST9_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST9_4H,0)) ST9_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST9_45,0)) ST9_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST10_20,0)) ST10_20_OPR2, MAX(DECODE(ROW_NUM,2,ST10_2H,0)) ST10_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST10_40,0)) ST10_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST10_4H,0)) ST10_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST10_45,0)) ST10_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST11_20,0)) ST11_20_OPR2, MAX(DECODE(ROW_NUM,2,ST11_2H,0)) ST11_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST11_40,0)) ST11_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST11_4H,0)) ST11_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST11_45,0)) ST11_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST12_20,0)) ST12_20_OPR2, MAX(DECODE(ROW_NUM,2,ST12_2H,0)) ST12_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST12_40,0)) ST12_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST12_4H,0)) ST12_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST12_45,0)) ST12_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST13_20,0)) ST13_20_OPR2, MAX(DECODE(ROW_NUM,2,ST13_2H,0)) ST13_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST13_40,0)) ST13_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST13_4H,0)) ST13_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST13_45,0)) ST13_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST14_20,0)) ST14_20_OPR2, MAX(DECODE(ROW_NUM,2,ST14_2H,0)) ST14_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST14_40,0)) ST14_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST14_4H,0)) ST14_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST14_45,0)) ST14_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST15_20,0)) ST15_20_OPR2, MAX(DECODE(ROW_NUM,2,ST15_2H,0)) ST15_2H_OPR2, MAX(DECODE(ROW_NUM,2,ST15_40,0)) ST15_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,ST15_4H,0)) ST15_4H_OPR2, MAX(DECODE(ROW_NUM,2,ST15_45,0)) ST15_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,OPR,0))   OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST1_20,0)) ST1_20_OPR3, MAX(DECODE(ROW_NUM,3,ST1_2H,0)) ST1_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST1_40,0)) ST1_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST1_4H,0)) ST1_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST1_45,0)) ST1_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST2_20,0)) ST2_20_OPR3, MAX(DECODE(ROW_NUM,3,ST2_2H,0)) ST2_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST2_40,0)) ST2_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST2_4H,0)) ST2_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST2_45,0)) ST2_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST3_20,0)) ST3_20_OPR3, MAX(DECODE(ROW_NUM,3,ST3_2H,0)) ST3_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST3_40,0)) ST3_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST3_4H,0)) ST3_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST3_45,0)) ST3_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST4_20,0)) ST4_20_OPR3, MAX(DECODE(ROW_NUM,3,ST4_2H,0)) ST4_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST4_40,0)) ST4_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST4_4H,0)) ST4_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST4_45,0)) ST4_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST5_20,0)) ST5_20_OPR3, MAX(DECODE(ROW_NUM,3,ST5_2H,0)) ST5_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST5_40,0)) ST5_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST5_4H,0)) ST5_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST5_45,0)) ST5_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST6_20,0)) ST6_20_OPR3, MAX(DECODE(ROW_NUM,3,ST6_2H,0)) ST6_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST6_40,0)) ST6_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST6_4H,0)) ST6_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST6_45,0)) ST6_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST7_20,0)) ST7_20_OPR3, MAX(DECODE(ROW_NUM,3,ST7_2H,0)) ST7_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST7_40,0)) ST7_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST7_4H,0)) ST7_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST7_45,0)) ST7_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST8_20,0)) ST8_20_OPR3, MAX(DECODE(ROW_NUM,3,ST8_2H,0)) ST8_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST8_40,0)) ST8_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST8_4H,0)) ST8_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST8_45,0)) ST8_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST9_20,0)) ST9_20_OPR3, MAX(DECODE(ROW_NUM,3,ST9_2H,0)) ST9_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST9_40,0)) ST9_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST9_4H,0)) ST9_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST9_45,0)) ST9_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST10_20,0)) ST10_20_OPR3, MAX(DECODE(ROW_NUM,3,ST10_2H,0)) ST10_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST10_40,0)) ST10_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST10_4H,0)) ST10_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST10_45,0)) ST10_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST11_20,0)) ST11_20_OPR3, MAX(DECODE(ROW_NUM,3,ST11_2H,0)) ST11_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST11_40,0)) ST11_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST11_4H,0)) ST11_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST11_45,0)) ST11_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST12_20,0)) ST12_20_OPR3, MAX(DECODE(ROW_NUM,3,ST12_2H,0)) ST12_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST12_40,0)) ST12_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST12_4H,0)) ST12_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST12_45,0)) ST12_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST13_20,0)) ST13_20_OPR3, MAX(DECODE(ROW_NUM,3,ST13_2H,0)) ST13_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST13_40,0)) ST13_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST13_4H,0)) ST13_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST13_45,0)) ST13_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST14_20,0)) ST14_20_OPR3, MAX(DECODE(ROW_NUM,3,ST14_2H,0)) ST14_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST14_40,0)) ST14_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST14_4H,0)) ST14_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST14_45,0)) ST14_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST15_20,0)) ST15_20_OPR3, MAX(DECODE(ROW_NUM,3,ST15_2H,0)) ST15_2H_OPR3, MAX(DECODE(ROW_NUM,3,ST15_40,0)) ST15_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,ST15_4H,0)) ST15_4H_OPR3, MAX(DECODE(ROW_NUM,3,ST15_45,0)) ST15_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,OPR,0))   OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST1_20,0)) ST1_20_OPR4, MAX(DECODE(ROW_NUM,4,ST1_2H,0)) ST1_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST1_40,0)) ST1_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST1_4H,0)) ST1_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST1_45,0)) ST1_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST2_20,0)) ST2_20_OPR4, MAX(DECODE(ROW_NUM,4,ST2_2H,0)) ST2_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST2_40,0)) ST2_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST2_4H,0)) ST2_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST2_45,0)) ST2_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST3_20,0)) ST3_20_OPR4, MAX(DECODE(ROW_NUM,4,ST3_2H,0)) ST3_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST3_40,0)) ST3_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST3_4H,0)) ST3_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST3_45,0)) ST3_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST4_20,0)) ST4_20_OPR4, MAX(DECODE(ROW_NUM,4,ST4_2H,0)) ST4_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST4_40,0)) ST4_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST4_4H,0)) ST4_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST4_45,0)) ST4_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST5_20,0)) ST5_20_OPR4, MAX(DECODE(ROW_NUM,4,ST5_2H,0)) ST5_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST5_40,0)) ST5_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST5_4H,0)) ST5_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST5_45,0)) ST5_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST6_20,0)) ST6_20_OPR4, MAX(DECODE(ROW_NUM,4,ST6_2H,0)) ST6_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST6_40,0)) ST6_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST6_4H,0)) ST6_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST6_45,0)) ST6_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST7_20,0)) ST7_20_OPR4, MAX(DECODE(ROW_NUM,4,ST7_2H,0)) ST7_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST7_40,0)) ST7_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST7_4H,0)) ST7_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST7_45,0)) ST7_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST8_20,0)) ST8_20_OPR4, MAX(DECODE(ROW_NUM,4,ST8_2H,0)) ST8_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST8_40,0)) ST8_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST8_4H,0)) ST8_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST8_45,0)) ST8_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST9_20,0)) ST9_20_OPR4, MAX(DECODE(ROW_NUM,4,ST9_2H,0)) ST9_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST9_40,0)) ST9_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST9_4H,0)) ST9_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST9_45,0)) ST9_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST10_20,0)) ST10_20_OPR4, MAX(DECODE(ROW_NUM,4,ST10_2H,0)) ST10_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST10_40,0)) ST10_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST10_4H,0)) ST10_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST10_45,0)) ST10_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST11_20,0)) ST11_20_OPR4, MAX(DECODE(ROW_NUM,4,ST11_2H,0)) ST11_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST11_40,0)) ST11_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST11_4H,0)) ST11_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST11_45,0)) ST11_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST12_20,0)) ST12_20_OPR4, MAX(DECODE(ROW_NUM,4,ST12_2H,0)) ST12_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST12_40,0)) ST12_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST12_4H,0)) ST12_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST12_45,0)) ST12_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST13_20,0)) ST13_20_OPR4, MAX(DECODE(ROW_NUM,4,ST13_2H,0)) ST13_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST13_40,0)) ST13_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST13_4H,0)) ST13_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST13_45,0)) ST13_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST14_20,0)) ST14_20_OPR4, MAX(DECODE(ROW_NUM,4,ST14_2H,0)) ST14_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST14_40,0)) ST14_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST14_4H,0)) ST14_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST14_45,0)) ST14_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST15_20,0)) ST15_20_OPR4, MAX(DECODE(ROW_NUM,4,ST15_2H,0)) ST15_2H_OPR4, MAX(DECODE(ROW_NUM,4,ST15_40,0)) ST15_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,ST15_4H,0)) ST15_4H_OPR4, MAX(DECODE(ROW_NUM,4,ST15_45,0)) ST15_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,OPR,0))   OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST1_20,0)) ST1_20_OPR5, MAX(DECODE(ROW_NUM,5,ST1_2H,0)) ST1_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST1_40,0)) ST1_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST1_4H,0)) ST1_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST1_45,0)) ST1_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST2_20,0)) ST2_20_OPR5, MAX(DECODE(ROW_NUM,5,ST2_2H,0)) ST2_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST2_40,0)) ST2_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST2_4H,0)) ST2_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST2_45,0)) ST2_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST3_20,0)) ST3_20_OPR5, MAX(DECODE(ROW_NUM,5,ST3_2H,0)) ST3_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST3_40,0)) ST3_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST3_4H,0)) ST3_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST3_45,0)) ST3_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST4_20,0)) ST4_20_OPR5, MAX(DECODE(ROW_NUM,5,ST4_2H,0)) ST4_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST4_40,0)) ST4_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST4_4H,0)) ST4_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST4_45,0)) ST4_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST5_20,0)) ST5_20_OPR5, MAX(DECODE(ROW_NUM,5,ST5_2H,0)) ST5_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST5_40,0)) ST5_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST5_4H,0)) ST5_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST5_45,0)) ST5_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST6_20,0)) ST6_20_OPR5, MAX(DECODE(ROW_NUM,5,ST6_2H,0)) ST6_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST6_40,0)) ST6_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST6_4H,0)) ST6_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST6_45,0)) ST6_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST7_20,0)) ST7_20_OPR5, MAX(DECODE(ROW_NUM,5,ST7_2H,0)) ST7_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST7_40,0)) ST7_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST7_4H,0)) ST7_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST7_45,0)) ST7_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST8_20,0)) ST8_20_OPR5, MAX(DECODE(ROW_NUM,5,ST8_2H,0)) ST8_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST8_40,0)) ST8_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST8_4H,0)) ST8_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST8_45,0)) ST8_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST9_20,0)) ST9_20_OPR5, MAX(DECODE(ROW_NUM,5,ST9_2H,0)) ST9_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST9_40,0)) ST9_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST9_4H,0)) ST9_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST9_45,0)) ST9_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST10_20,0)) ST10_20_OPR5, MAX(DECODE(ROW_NUM,5,ST10_2H,0)) ST10_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST10_40,0)) ST10_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST10_4H,0)) ST10_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST10_45,0)) ST10_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST11_20,0)) ST11_20_OPR5, MAX(DECODE(ROW_NUM,5,ST11_2H,0)) ST11_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST11_40,0)) ST11_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST11_4H,0)) ST11_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST11_45,0)) ST11_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST12_20,0)) ST12_20_OPR5, MAX(DECODE(ROW_NUM,5,ST12_2H,0)) ST12_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST12_40,0)) ST12_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST12_4H,0)) ST12_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST12_45,0)) ST12_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST13_20,0)) ST13_20_OPR5, MAX(DECODE(ROW_NUM,5,ST13_2H,0)) ST13_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST13_40,0)) ST13_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST13_4H,0)) ST13_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST13_45,0)) ST13_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST14_20,0)) ST14_20_OPR5, MAX(DECODE(ROW_NUM,5,ST14_2H,0)) ST14_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST14_40,0)) ST14_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST14_4H,0)) ST14_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST14_45,0)) ST14_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST15_20,0)) ST15_20_OPR5, MAX(DECODE(ROW_NUM,5,ST15_2H,0)) ST15_2H_OPR5, MAX(DECODE(ROW_NUM,5,ST15_40,0)) ST15_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,ST15_4H,0)) ST15_4H_OPR5, MAX(DECODE(ROW_NUM,5,ST15_45,0)) ST15_45_OPR5" ).append("\n"); 
		query.append("                       FROM ( SELECT POD," ).append("\n"); 
		query.append("                                     POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                     OPR," ).append("\n"); 
		query.append("                                     MLB," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST1_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST1_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST1_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST1_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST1_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST2_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST2_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST2_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST2_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST2_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST3_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST3_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST3_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST3_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST3_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST4_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST4_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST4_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST4_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST4_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST5_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST5_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST5_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST5_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST5_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST6_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST6_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST6_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST6_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST6_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST7_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST7_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST7_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST7_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST7_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST8_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST8_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST8_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST8_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST8_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST9_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST9_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST9_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST9_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST9_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST10_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST10_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST10_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST10_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST10_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST11_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST11_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST11_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST11_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST11_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST12_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST12_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST12_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST12_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST12_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST13_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST13_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST13_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST13_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST13_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST14_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST14_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST14_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST14_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST14_45," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) ST15_20," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST15_2H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) ST15_40," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST15_4H," ).append("\n"); 
		query.append("                                     --SUM(DECODE(STWG_CD,[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST15_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST1_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST1_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST1_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST1_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_1],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST1_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST2_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST2_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST2_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST2_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_2],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST2_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST3_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST3_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST3_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST3_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_3],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST3_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST4_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST4_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST4_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST4_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_4],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST4_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST5_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST5_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST5_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST5_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_5],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST5_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST6_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST6_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST6_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST6_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_6],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST6_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST7_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST7_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST7_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST7_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_7],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST7_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST8_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST8_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST8_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST8_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_8],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST8_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST9_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST9_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST9_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST9_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_9],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST9_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST10_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST10_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST10_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST10_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_10],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST10_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST11_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST11_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST11_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST11_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_11],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST11_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST12_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST12_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST12_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST12_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_12],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST12_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST13_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST13_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST13_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST13_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_13],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST13_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST14_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST14_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST14_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST14_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_14],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST14_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))+SUM(DECODE(STWG_CD,@[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'A',1,0),0)) ST15_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) ST15_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0))+SUM(DECODE(STWG_CD,@[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'B',1,0),0)) ST15_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,0),0)) ST15_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CD,@[st_15],DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) ST15_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                     MIN(ROW_NUM) ROW_NUM" ).append("\n"); 
		query.append("                              FROM ( SELECT DISTINCT " ).append("\n"); 
		query.append("                                            POD," ).append("\n"); 
		query.append("                                            POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                            OPR," ).append("\n"); 
		query.append("                                            MLB," ).append("\n"); 
		query.append("                                            BKG_NO," ).append("\n"); 
		query.append("                                            CNTR_NO," ).append("\n"); 
		query.append("                                            STWG_CD," ).append("\n"); 
		query.append("                                            CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                            ROW_NUM" ).append("\n"); 
		query.append("                                     FROM   ( SELECT D.POD_CD   POD," ).append("\n"); 
		query.append("                                                     D.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                                     D.CRR_CD   OPR," ).append("\n"); 
		query.append("                                                     D.MLB_CD   MLB," ).append("\n"); 
		query.append("                                                     DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.BKG_NO, D.PRNR_BKG_REF_NO) BKG_NO," ).append("\n"); 
		query.append("                                                     DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.CNTR_NO, D.PRNR_CNTR_REF_NO) CNTR_NO," ).append("\n"); 
		query.append("                                                     D.STWG_CD," ).append("\n"); 
		query.append("                                                     D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                                     ( CASE WHEN D.CRR_CD = @[qty1] THEN 1" ).append("\n"); 
		query.append("                                                            WHEN D.CRR_CD = @[qty2] THEN 2                                                                                              " ).append("\n"); 
		query.append("                                                            WHEN D.CRR_CD = @[qty3] THEN 3                                                                                              " ).append("\n"); 
		query.append("                                                            WHEN D.CRR_CD = @[qty4] THEN 4                                                                                              " ).append("\n"); 
		query.append("                                                            WHEN D.CRR_CD = @[qty5] THEN 5                                                                                              " ).append("\n"); 
		query.append("                                                       END) ROW_NUM," ).append("\n"); 
		query.append("                                                     DECODE(DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.CNTR_NO, D.PRNR_CNTR_REF_NO),NULL,1,ROW_NUMBER() OVER (PARTITION BY D.CRR_CD, DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.CNTR_NO, D.PRNR_CNTR_REF_NO), D.CNTR_SEQ, D.STWG_CD ORDER BY DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.BKG_NO, D.PRNR_BKG_REF_NO))) CNTR_RN" ).append("\n"); 
		query.append("                                              FROM   OPF_CGO_BKG_FCAST H, OPF_CGO_BKG_FCAST_CNTR D" ).append("\n"); 
		query.append("                                              WHERE  H.VSL_CD                    = @[vsl_cd]                                                                                                    " ).append("\n"); 
		query.append("                                              AND    H.SKD_VOY_NO                = @[skd_voy_no]                                                                                                " ).append("\n"); 
		query.append("                                              AND    H.SKD_DIR_CD                = @[skd_dir_cd]                                                                                                " ).append("\n"); 
		query.append("                                              AND    H.YD_CD||H.POL_CLPT_IND_SEQ = @[yd_cd]                                                                                                     " ).append("\n"); 
		query.append("                                              AND    H.VSL_CD            = D.VSL_CD" ).append("\n"); 
		query.append("                                              AND    H.SKD_VOY_NO        = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                                              AND    H.SKD_DIR_CD        = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                              AND    H.BKG_SHPR_OWNR_FLG = D.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append("                                              AND    H.CRR_CD            = D.CRR_CD" ).append("\n"); 
		query.append("                                              AND    H.YD_CD             = D.YD_CD" ).append("\n"); 
		query.append("                                              AND    H.POL_CLPT_IND_SEQ  = D.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                              AND    D.CBF_DP_CD         = 'S'" ).append("\n"); 
		query.append("                                              AND    D.STWG_CGO_FLG      = 'Y'" ).append("\n"); 
		query.append("                                              AND    D.STWG_CD           IS NOT NULL" ).append("\n"); 
		query.append("                                              AND    D.CRR_CD IN ( @[qty1], @[qty2], @[qty3], @[qty4], @[qty5] )" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("					                          AND D.POD_CD||D.POD_CLPT_IND_SEQ LIKE @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mlb_cd} != '')" ).append("\n"); 
		query.append("					                          AND D.MLB_CD LIKE @[mlb_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${all_flg} != 'Y')" ).append("\n"); 
		query.append("                                              AND CASE WHEN @[dcgo_flg] IS NULL AND @[rc_flg] IS NULL AND @[awk_cgo_flg] IS NULL AND @[bb_cgo_flg] IS NULL AND @[stwg_cgo_flg] IS NULL THEN 1 " ).append("\n"); 
		query.append("                                                       ELSE DECODE(D.DCGO_FLG,@[dcgo_flg],1,0)+DECODE(D.RC_FLG,@[rc_flg],1,0)+DECODE(D.AWK_CGO_FLG,@[awk_cgo_flg],1,0)+DECODE(D.BB_CGO_FLG,@[bb_cgo_flg],1,0)+DECODE(DECODE(D.STWG_CD,NULL,'N','Y'),@[stwg_cgo_flg],1,0)" ).append("\n"); 
		query.append("                                                  END  >=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                     WHERE CNTR_RN = 1 )" ).append("\n"); 
		query.append("                              GROUP BY POD, POD_CLPT_IND_SEQ, OPR, MLB )" ).append("\n"); 
		query.append("                       GROUP BY POD, POD_CLPT_IND_SEQ, MLB )" ).append("\n"); 
		query.append("               GROUP BY CUBE(POD||POD_CLPT_IND_SEQ, MLB) ) A," ).append("\n"); 
		query.append("               ( SELECT V.VPS_PORT_CD PORT, V.CLPT_IND_SEQ, V.CLPT_SEQ SEQ" ).append("\n"); 
		query.append("                 FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                 WHERE  V.VSL_CD     = @[vsl_cd]                                                                                                                                        " ).append("\n"); 
		query.append("                 AND    V.SKD_VOY_NO = @[skd_voy_no]                                                                                                                                    " ).append("\n"); 
		query.append("                 AND    V.SKD_DIR_CD = @[skd_dir_cd]                                                                                                                                    " ).append("\n"); 
		query.append("                 AND    V.CLPT_SEQ   > ( SELECT CLPT_SEQ                                                                                                                                " ).append("\n"); 
		query.append("                                         FROM   VSK_VSL_PORT_SKD R                                                                                                                      " ).append("\n"); 
		query.append("                                         WHERE  R.VSL_CD                = @[vsl_cd]                                                                                                                " ).append("\n"); 
		query.append("                                         AND    R.SKD_VOY_NO            = @[skd_voy_no]                                                                                                            " ).append("\n"); 
		query.append("                                         AND    R.SKD_DIR_CD            = @[skd_dir_cd]                                                                                                            " ).append("\n"); 
		query.append("                                         AND    R.YD_CD||R.CLPT_IND_SEQ = @[yd_cd]                                                                                                         " ).append("\n"); 
		query.append("                                         AND    ROWNUM = 1 ) ) P                                                                                                                        " ).append("\n"); 
		query.append("       WHERE NVL(C2,0) = 1" ).append("\n"); 
		query.append("       AND   SUBSTR(A.POD,1,5) = P.PORT(+) " ).append("\n"); 
		query.append("       AND   SUBSTR(A.POD,6,1) = P.CLPT_IND_SEQ(+))" ).append("\n"); 
		query.append("ORDER BY SEQ, DECODE(POD,'G.Total','ZZZZZ',SUBSTR(POD,1,5)), DECODE(NVL(MLB,'YYY'),'S.Total','ZZZ',NVL(MLB,'YYY')) ASC" ).append("\n"); 

	}
}