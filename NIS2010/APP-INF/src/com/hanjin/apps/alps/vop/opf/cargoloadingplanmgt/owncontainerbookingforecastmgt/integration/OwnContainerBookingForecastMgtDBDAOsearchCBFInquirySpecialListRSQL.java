/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFInquirySpecialListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.25
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2013.06.25 서관영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seo Kwan Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchCBFInquirySpecialListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFInquirySpecialList
	  * 2011.06.27 
	  * Ticket ID : [CHM-201111635-01]
	  * 개발자  : 이준범
	  * 제   목 : R9신규코드추가 관련 로직 추가
	  * 내   용 : Ultra Freezer container (R9) 추가로 인하여 해당 R9을 D5로 인식하여 표시될수 있도록 SQL문 수정
	  * -------------------------------------------------------------------------------------------------------------------
	  * 2012.12.03 CHM-201221299-01 이혜민 신규 장비 R8 을 40’HC으로 분류하여 CBF 및 COD 메뉴에 반영
	  * 2013.06.20 CHM-201324915 SKY  CBF – POD TMNL code로 구분
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchCBFInquirySpecialListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qty1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qty2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qty5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFInquirySpecialListRSQL").append("\n"); 
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
		query.append("       DECODE(POD,'','',SUBSTR(POD,12,2)) AS POD_YD_CD," ).append("\n"); 
		query.append("       MLB," ).append("\n"); 
		query.append("#if (${qty1} != '')" ).append("\n"); 
		query.append("       OPR1," ).append("\n"); 
		query.append("       DG_20_OPR1, DG_2H_OPR1, DG_40_OPR1, DG_4H_OPR1," ).append("\n"); 
		query.append("       DG_45_OPR1, RF_20_OPR1, RF_2H_OPR1, RF_40_OPR1," ).append("\n"); 
		query.append("       RF_4H_OPR1, RF_45_OPR1, AK_20_OPR1, AK_40_OPR1," ).append("\n"); 
		query.append("       AK_4H_OPR1, AK_45_OPR1, BB_20_OPR1, BB_40_OPR1," ).append("\n"); 
		query.append("	   STWG_20_OPR1, STWG_2H_OPR1, STWG_40_OPR1, STWG_4H_OPR1, STWG_45_OPR1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${qty2} != '')" ).append("\n"); 
		query.append("       OPR2," ).append("\n"); 
		query.append("       DG_20_OPR2, DG_2H_OPR2, DG_40_OPR2, DG_4H_OPR2," ).append("\n"); 
		query.append("       DG_45_OPR2, RF_20_OPR2, RF_2H_OPR2, RF_40_OPR2," ).append("\n"); 
		query.append("       RF_4H_OPR2, RF_45_OPR2, AK_20_OPR2, AK_40_OPR2," ).append("\n"); 
		query.append("       AK_4H_OPR2, AK_45_OPR2, BB_20_OPR2, BB_40_OPR2," ).append("\n"); 
		query.append("	   STWG_20_OPR2, STWG_2H_OPR2, STWG_40_OPR2, STWG_4H_OPR2, STWG_45_OPR2," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${qty3} != '')" ).append("\n"); 
		query.append("       OPR3," ).append("\n"); 
		query.append("       DG_20_OPR3, DG_2H_OPR3, DG_40_OPR3, DG_4H_OPR3," ).append("\n"); 
		query.append("       DG_45_OPR3, RF_20_OPR3, RF_2H_OPR3, RF_40_OPR3," ).append("\n"); 
		query.append("       RF_4H_OPR3, RF_45_OPR3, AK_20_OPR3, AK_40_OPR3," ).append("\n"); 
		query.append("       AK_4H_OPR3, AK_45_OPR3, BB_20_OPR3, BB_40_OPR3," ).append("\n"); 
		query.append("	   STWG_20_OPR3, STWG_2H_OPR3, STWG_40_OPR3, STWG_4H_OPR3, STWG_45_OPR3," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${qty4} != '')" ).append("\n"); 
		query.append("       OPR4," ).append("\n"); 
		query.append("       DG_20_OPR4, DG_2H_OPR4, DG_40_OPR4, DG_4H_OPR4," ).append("\n"); 
		query.append("       DG_45_OPR4, RF_20_OPR4, RF_2H_OPR4, RF_40_OPR4," ).append("\n"); 
		query.append("       RF_4H_OPR4, RF_45_OPR4, AK_20_OPR4, AK_40_OPR4," ).append("\n"); 
		query.append("       AK_4H_OPR4, AK_45_OPR4, BB_20_OPR4, BB_40_OPR4," ).append("\n"); 
		query.append("	   STWG_20_OPR4, STWG_2H_OPR4, STWG_40_OPR4, STWG_4H_OPR4, STWG_45_OPR4," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${qty5} != '')" ).append("\n"); 
		query.append("       OPR5," ).append("\n"); 
		query.append("       DG_20_OPR5, DG_2H_OPR5, DG_40_OPR5, DG_4H_OPR5," ).append("\n"); 
		query.append("       DG_45_OPR5, RF_20_OPR5, RF_2H_OPR5, RF_40_OPR5," ).append("\n"); 
		query.append("       RF_4H_OPR5, RF_45_OPR5, AK_20_OPR5, AK_40_OPR5," ).append("\n"); 
		query.append("       AK_4H_OPR5, AK_45_OPR5, BB_20_OPR5, BB_40_OPR5," ).append("\n"); 
		query.append("	   STWG_20_OPR5, STWG_2H_OPR5, STWG_40_OPR5, STWG_4H_OPR5, STWG_45_OPR5," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       DG_20_OPR1+DG_20_OPR2+DG_20_OPR3+DG_20_OPR4+DG_20_OPR5 DG_20_TOT," ).append("\n"); 
		query.append("       DG_2H_OPR1+DG_2H_OPR2+DG_2H_OPR3+DG_2H_OPR4+DG_2H_OPR5 DG_2H_TOT," ).append("\n"); 
		query.append("       DG_40_OPR1+DG_40_OPR2+DG_40_OPR3+DG_40_OPR4+DG_40_OPR5 DG_40_TOT," ).append("\n"); 
		query.append("       DG_4H_OPR1+DG_4H_OPR2+DG_4H_OPR3+DG_4H_OPR4+DG_4H_OPR5 DG_4H_TOT," ).append("\n"); 
		query.append("       DG_45_OPR1+DG_45_OPR2+DG_45_OPR3+DG_45_OPR4+DG_45_OPR5 DG_45_TOT," ).append("\n"); 
		query.append("       RF_20_OPR1+RF_20_OPR2+RF_20_OPR3+RF_20_OPR4+RF_20_OPR5 RF_20_TOT," ).append("\n"); 
		query.append("       RF_2H_OPR1+RF_2H_OPR2+RF_2H_OPR3+RF_2H_OPR4+RF_2H_OPR5 RF_2H_TOT," ).append("\n"); 
		query.append("       RF_40_OPR1+RF_40_OPR2+RF_40_OPR3+RF_40_OPR4+RF_40_OPR5 RF_40_TOT," ).append("\n"); 
		query.append("       RF_4H_OPR1+RF_4H_OPR2+RF_4H_OPR3+RF_4H_OPR4+RF_4H_OPR5 RF_4H_TOT," ).append("\n"); 
		query.append("       RF_45_OPR1+RF_45_OPR2+RF_45_OPR3+RF_45_OPR4+RF_45_OPR5 RF_45_TOT," ).append("\n"); 
		query.append("       AK_20_OPR1+AK_20_OPR2+AK_20_OPR3+AK_20_OPR4+AK_20_OPR5 AK_20_TOT," ).append("\n"); 
		query.append("       AK_40_OPR1+AK_40_OPR2+AK_40_OPR3+AK_40_OPR4+AK_40_OPR5 AK_40_TOT," ).append("\n"); 
		query.append("       AK_4H_OPR1+AK_4H_OPR2+AK_4H_OPR3+AK_4H_OPR4+AK_4H_OPR5 AK_4H_TOT," ).append("\n"); 
		query.append("       AK_45_OPR1+AK_45_OPR2+AK_45_OPR3+AK_45_OPR4+AK_45_OPR5 AK_45_TOT," ).append("\n"); 
		query.append("       BB_20_OPR1+BB_20_OPR2+BB_20_OPR3+BB_20_OPR4+BB_20_OPR5 BB_20_TOT," ).append("\n"); 
		query.append("       BB_40_OPR1+BB_40_OPR2+BB_40_OPR3+BB_40_OPR4+BB_40_OPR5 BB_40_TOT," ).append("\n"); 
		query.append("	   STWG_20_OPR1+STWG_20_OPR2+STWG_20_OPR3+STWG_20_OPR4+STWG_20_OPR5 STWG_20_TOT," ).append("\n"); 
		query.append("       STWG_2H_OPR1+STWG_2H_OPR2+STWG_2H_OPR3+STWG_2H_OPR4+STWG_2H_OPR5 STWG_2H_TOT," ).append("\n"); 
		query.append("       STWG_40_OPR1+STWG_40_OPR2+STWG_40_OPR3+STWG_40_OPR4+STWG_40_OPR5 STWG_40_TOT," ).append("\n"); 
		query.append("       STWG_4H_OPR1+STWG_4H_OPR2+STWG_4H_OPR3+STWG_4H_OPR4+STWG_4H_OPR5 STWG_4H_TOT," ).append("\n"); 
		query.append("       STWG_45_OPR1+STWG_45_OPR2+STWG_45_OPR3+STWG_45_OPR4+STWG_45_OPR5 STWG_45_TOT" ).append("\n"); 
		query.append("FROM ( SELECT CASE " ).append("\n"); 
		query.append("              WHEN P=1 AND M=1 THEN 'G.Total'" ).append("\n"); 
		query.append("              ELSE POD" ).append("\n"); 
		query.append("              END  POD," ).append("\n"); 
		query.append("              CASE " ).append("\n"); 
		query.append("              WHEN P=0 AND M=1 THEN 'S.Total'" ).append("\n"); 
		query.append("              ELSE MLB" ).append("\n"); 
		query.append("              END  MLB," ).append("\n"); 
		query.append("              OPR1," ).append("\n"); 
		query.append("              DG_20_OPR1, DG_2H_OPR1, DG_40_OPR1, DG_4H_OPR1," ).append("\n"); 
		query.append("              DG_45_OPR1, RF_20_OPR1, RF_2H_OPR1, RF_40_OPR1," ).append("\n"); 
		query.append("              RF_4H_OPR1, RF_45_OPR1, AK_20_OPR1, AK_40_OPR1," ).append("\n"); 
		query.append("              AK_4H_OPR1, AK_45_OPR1, BB_20_OPR1, BB_40_OPR1," ).append("\n"); 
		query.append("			  STWG_20_OPR1, STWG_2H_OPR1, STWG_40_OPR1, STWG_4H_OPR1, STWG_45_OPR1," ).append("\n"); 
		query.append("              OPR2," ).append("\n"); 
		query.append("              DG_20_OPR2, DG_2H_OPR2, DG_40_OPR2, DG_4H_OPR2," ).append("\n"); 
		query.append("              DG_45_OPR2, RF_20_OPR2, RF_2H_OPR2, RF_40_OPR2," ).append("\n"); 
		query.append("              RF_4H_OPR2, RF_45_OPR2, AK_20_OPR2, AK_40_OPR2," ).append("\n"); 
		query.append("              AK_4H_OPR2, AK_45_OPR2, BB_20_OPR2, BB_40_OPR2," ).append("\n"); 
		query.append("			  STWG_20_OPR2, STWG_2H_OPR2, STWG_40_OPR2, STWG_4H_OPR2, STWG_45_OPR2," ).append("\n"); 
		query.append("              OPR3," ).append("\n"); 
		query.append("              DG_20_OPR3, DG_2H_OPR3, DG_40_OPR3, DG_4H_OPR3," ).append("\n"); 
		query.append("              DG_45_OPR3, RF_20_OPR3, RF_2H_OPR3, RF_40_OPR3," ).append("\n"); 
		query.append("              RF_4H_OPR3, RF_45_OPR3, AK_20_OPR3, AK_40_OPR3," ).append("\n"); 
		query.append("              AK_4H_OPR3, AK_45_OPR3, BB_20_OPR3, BB_40_OPR3," ).append("\n"); 
		query.append("			  STWG_20_OPR3, STWG_2H_OPR3, STWG_40_OPR3, STWG_4H_OPR3, STWG_45_OPR3," ).append("\n"); 
		query.append("              OPR4," ).append("\n"); 
		query.append("              DG_20_OPR4, DG_2H_OPR4, DG_40_OPR4, DG_4H_OPR4," ).append("\n"); 
		query.append("              DG_45_OPR4, RF_20_OPR4, RF_2H_OPR4, RF_40_OPR4," ).append("\n"); 
		query.append("              RF_4H_OPR4, RF_45_OPR4, AK_20_OPR4, AK_40_OPR4," ).append("\n"); 
		query.append("              AK_4H_OPR4, AK_45_OPR4, BB_20_OPR4, BB_40_OPR4," ).append("\n"); 
		query.append("			  STWG_20_OPR4, STWG_2H_OPR4, STWG_40_OPR4, STWG_4H_OPR4, STWG_45_OPR4," ).append("\n"); 
		query.append("              OPR5," ).append("\n"); 
		query.append("              DG_20_OPR5, DG_2H_OPR5, DG_40_OPR5, DG_4H_OPR5," ).append("\n"); 
		query.append("              DG_45_OPR5, RF_20_OPR5, RF_2H_OPR5, RF_40_OPR5," ).append("\n"); 
		query.append("              RF_4H_OPR5, RF_45_OPR5, AK_20_OPR5, AK_40_OPR5," ).append("\n"); 
		query.append("              AK_4H_OPR5, AK_45_OPR5, BB_20_OPR5, BB_40_OPR5," ).append("\n"); 
		query.append("			  STWG_20_OPR5, STWG_2H_OPR5, STWG_40_OPR5, STWG_4H_OPR5, STWG_45_OPR5," ).append("\n"); 
		query.append("              P.SEQ" ).append("\n"); 
		query.append("       FROM   ( SELECT (POD||POD_CLPT_IND_SEQ||POD_YD_CD) AS POD, MLB," ).append("\n"); 
		query.append("                       GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD) P, GROUPING(MLB) M," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD)=0 AND GROUPING(MLB)=1 THEN 1" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD)=0 AND GROUPING(MLB)=0 THEN 1" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD)=0 AND GROUPING(MLB)=1 THEN 1" ).append("\n"); 
		query.append("                       WHEN GROUPING(POD||POD_CLPT_IND_SEQ||POD_YD_CD)=1 AND GROUPING(MLB)=1 THEN 1" ).append("\n"); 
		query.append("                       ELSE 0" ).append("\n"); 
		query.append("                       END C2," ).append("\n"); 
		query.append("                       MAX(OPR1) OPR1," ).append("\n"); 
		query.append("                       SUM(DG_20_OPR1) DG_20_OPR1, SUM(DG_2H_OPR1) DG_2H_OPR1, SUM(DG_40_OPR1) DG_40_OPR1, SUM(DG_4H_OPR1) DG_4H_OPR1," ).append("\n"); 
		query.append("                       SUM(DG_45_OPR1) DG_45_OPR1, SUM(RF_20_OPR1) RF_20_OPR1, SUM(RF_2H_OPR1) RF_2H_OPR1, SUM(RF_40_OPR1) RF_40_OPR1," ).append("\n"); 
		query.append("                       SUM(RF_4H_OPR1) RF_4H_OPR1, SUM(RF_45_OPR1) RF_45_OPR1, SUM(AK_20_OPR1) AK_20_OPR1, SUM(AK_40_OPR1) AK_40_OPR1," ).append("\n"); 
		query.append("                       SUM(AK_4H_OPR1) AK_4H_OPR1, SUM(AK_45_OPR1) AK_45_OPR1, SUM(BB_20_OPR1) BB_20_OPR1, SUM(BB_40_OPR1) BB_40_OPR1," ).append("\n"); 
		query.append("					   SUM(STWG_20_OPR1) STWG_20_OPR1, SUM(STWG_2H_OPR1) STWG_2H_OPR1, SUM(STWG_40_OPR1) STWG_40_OPR1, SUM(STWG_4H_OPR1) STWG_4H_OPR1, SUM(STWG_45_OPR1) STWG_45_OPR1," ).append("\n"); 
		query.append("                       MAX(OPR2) OPR2," ).append("\n"); 
		query.append("                       SUM(DG_20_OPR2) DG_20_OPR2, SUM(DG_2H_OPR2) DG_2H_OPR2, SUM(DG_40_OPR2) DG_40_OPR2, SUM(DG_4H_OPR2) DG_4H_OPR2," ).append("\n"); 
		query.append("                       SUM(DG_45_OPR2) DG_45_OPR2, SUM(RF_20_OPR2) RF_20_OPR2, SUM(RF_2H_OPR2) RF_2H_OPR2, SUM(RF_40_OPR2) RF_40_OPR2," ).append("\n"); 
		query.append("                       SUM(RF_4H_OPR2) RF_4H_OPR2, SUM(RF_45_OPR2) RF_45_OPR2, SUM(AK_20_OPR2) AK_20_OPR2, SUM(AK_40_OPR2) AK_40_OPR2," ).append("\n"); 
		query.append("                       SUM(AK_4H_OPR2) AK_4H_OPR2, SUM(AK_45_OPR2) AK_45_OPR2, SUM(BB_20_OPR2) BB_20_OPR2, SUM(BB_40_OPR2) BB_40_OPR2," ).append("\n"); 
		query.append("					   SUM(STWG_20_OPR2) STWG_20_OPR2, SUM(STWG_2H_OPR2) STWG_2H_OPR2, SUM(STWG_40_OPR2) STWG_40_OPR2, SUM(STWG_4H_OPR2) STWG_4H_OPR2, SUM(STWG_45_OPR2) STWG_45_OPR2," ).append("\n"); 
		query.append("                       MAX(OPR3) OPR3," ).append("\n"); 
		query.append("                       SUM(DG_20_OPR3) DG_20_OPR3, SUM(DG_2H_OPR3) DG_2H_OPR3, SUM(DG_40_OPR3) DG_40_OPR3, SUM(DG_4H_OPR3) DG_4H_OPR3," ).append("\n"); 
		query.append("                       SUM(DG_45_OPR3) DG_45_OPR3, SUM(RF_20_OPR3) RF_20_OPR3, SUM(RF_2H_OPR3) RF_2H_OPR3, SUM(RF_40_OPR3) RF_40_OPR3," ).append("\n"); 
		query.append("                       SUM(RF_4H_OPR3) RF_4H_OPR3, SUM(RF_45_OPR3) RF_45_OPR3, SUM(AK_20_OPR3) AK_20_OPR3, SUM(AK_40_OPR3) AK_40_OPR3," ).append("\n"); 
		query.append("                       SUM(AK_4H_OPR3) AK_4H_OPR3, SUM(AK_45_OPR3) AK_45_OPR3, SUM(BB_20_OPR3) BB_20_OPR3, SUM(BB_40_OPR3) BB_40_OPR3," ).append("\n"); 
		query.append("					   SUM(STWG_20_OPR3) STWG_20_OPR3, SUM(STWG_2H_OPR3) STWG_2H_OPR3, SUM(STWG_40_OPR3) STWG_40_OPR3, SUM(STWG_4H_OPR3) STWG_4H_OPR3, SUM(STWG_45_OPR3) STWG_45_OPR3," ).append("\n"); 
		query.append("                       MAX(OPR4) OPR4," ).append("\n"); 
		query.append("                       SUM(DG_20_OPR4) DG_20_OPR4, SUM(DG_2H_OPR4) DG_2H_OPR4, SUM(DG_40_OPR4) DG_40_OPR4, SUM(DG_4H_OPR4) DG_4H_OPR4," ).append("\n"); 
		query.append("                       SUM(DG_45_OPR4) DG_45_OPR4, SUM(RF_20_OPR4) RF_20_OPR4, SUM(RF_2H_OPR4) RF_2H_OPR4, SUM(RF_40_OPR4) RF_40_OPR4," ).append("\n"); 
		query.append("                       SUM(RF_4H_OPR4) RF_4H_OPR4, SUM(RF_45_OPR4) RF_45_OPR4, SUM(AK_20_OPR4) AK_20_OPR4, SUM(AK_40_OPR4) AK_40_OPR4," ).append("\n"); 
		query.append("                       SUM(AK_4H_OPR4) AK_4H_OPR4, SUM(AK_45_OPR4) AK_45_OPR4, SUM(BB_20_OPR4) BB_20_OPR4, SUM(BB_40_OPR4) BB_40_OPR4," ).append("\n"); 
		query.append("					   SUM(STWG_20_OPR4) STWG_20_OPR4, SUM(STWG_2H_OPR4) STWG_2H_OPR4, SUM(STWG_40_OPR4) STWG_40_OPR4, SUM(STWG_4H_OPR4) STWG_4H_OPR4, SUM(STWG_45_OPR4) STWG_45_OPR4," ).append("\n"); 
		query.append("                       MAX(OPR5) OPR5," ).append("\n"); 
		query.append("                       SUM(DG_20_OPR5) DG_20_OPR5, SUM(DG_2H_OPR5) DG_2H_OPR5, SUM(DG_40_OPR5) DG_40_OPR5, SUM(DG_4H_OPR5) DG_4H_OPR5," ).append("\n"); 
		query.append("                       SUM(DG_45_OPR5) DG_45_OPR5, SUM(RF_20_OPR5) RF_20_OPR5, SUM(RF_2H_OPR5) RF_2H_OPR5, SUM(RF_40_OPR5) RF_40_OPR5," ).append("\n"); 
		query.append("                       SUM(RF_4H_OPR5) RF_4H_OPR5, SUM(RF_45_OPR5) RF_45_OPR5, SUM(AK_20_OPR5) AK_20_OPR5, SUM(AK_40_OPR5) AK_40_OPR5," ).append("\n"); 
		query.append("                       SUM(AK_4H_OPR5) AK_4H_OPR5, SUM(AK_45_OPR5) AK_45_OPR5, SUM(BB_20_OPR5) BB_20_OPR5, SUM(BB_40_OPR5) BB_40_OPR5," ).append("\n"); 
		query.append("					   SUM(STWG_20_OPR5) STWG_20_OPR5, SUM(STWG_2H_OPR5) STWG_2H_OPR5, SUM(STWG_40_OPR5) STWG_40_OPR5, SUM(STWG_4H_OPR5) STWG_4H_OPR5, SUM(STWG_45_OPR5) STWG_45_OPR5" ).append("\n"); 
		query.append("                FROM ( SELECT POD," ).append("\n"); 
		query.append("                              POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                              POD_YD_CD," ).append("\n"); 
		query.append("                              MLB," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,OPR,0))   OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_20,0)) DG_20_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_2H,0)) DG_2H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_40,0)) DG_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_4H,0)) DG_4H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,DG_45,0)) DG_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_20,0)) RF_20_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_2H,0)) RF_2H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_40,0)) RF_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_4H,0)) RF_4H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,RF_45,0)) RF_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,AK_20,0)) AK_20_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,AK_40,0)) AK_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,AK_4H,0)) AK_4H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,AK_45,0)) AK_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,BB_20,0)) BB_20_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,BB_40,0)) BB_40_OPR1," ).append("\n"); 
		query.append("							  MAX(DECODE(ROW_NUM,1,STWG_20,0)) STWG_20_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,STWG_2H,0)) STWG_2H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,STWG_40,0)) STWG_40_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,STWG_4H,0)) STWG_4H_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,1,STWG_45,0)) STWG_45_OPR1," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,OPR,0))   OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,DG_20,0)) DG_20_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,DG_2H,0)) DG_2H_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,DG_40,0)) DG_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,DG_4H,0)) DG_4H_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,DG_45,0)) DG_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,RF_20,0)) RF_20_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,RF_2H,0)) RF_2H_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,RF_40,0)) RF_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,RF_4H,0)) RF_4H_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,RF_45,0)) RF_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,AK_20,0)) AK_20_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,AK_40,0)) AK_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,AK_4H,0)) AK_4H_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,AK_45,0)) AK_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,BB_20,0)) BB_20_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,BB_40,0)) BB_40_OPR2," ).append("\n"); 
		query.append("							  MAX(DECODE(ROW_NUM,2,STWG_20,0)) STWG_20_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,STWG_2H,0)) STWG_2H_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,STWG_40,0)) STWG_40_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,STWG_4H,0)) STWG_4H_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,2,STWG_45,0)) STWG_45_OPR2," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,OPR,0))   OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,DG_20,0)) DG_20_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,DG_2H,0)) DG_2H_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,DG_40,0)) DG_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,DG_4H,0)) DG_4H_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,DG_45,0)) DG_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,RF_20,0)) RF_20_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,RF_2H,0)) RF_2H_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,RF_40,0)) RF_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,RF_4H,0)) RF_4H_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,RF_45,0)) RF_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,AK_20,0)) AK_20_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,AK_40,0)) AK_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,AK_4H,0)) AK_4H_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,AK_45,0)) AK_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,BB_20,0)) BB_20_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,BB_40,0)) BB_40_OPR3," ).append("\n"); 
		query.append("							  MAX(DECODE(ROW_NUM,3,STWG_20,0)) STWG_20_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,STWG_2H,0)) STWG_2H_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,STWG_40,0)) STWG_40_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,STWG_4H,0)) STWG_4H_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,3,STWG_45,0)) STWG_45_OPR3," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,OPR,0))   OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,DG_20,0)) DG_20_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,DG_2H,0)) DG_2H_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,DG_40,0)) DG_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,DG_4H,0)) DG_4H_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,DG_45,0)) DG_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,RF_20,0)) RF_20_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,RF_2H,0)) RF_2H_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,RF_40,0)) RF_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,RF_4H,0)) RF_4H_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,RF_45,0)) RF_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,AK_20,0)) AK_20_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,AK_40,0)) AK_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,AK_4H,0)) AK_4H_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,AK_45,0)) AK_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,BB_20,0)) BB_20_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,BB_40,0)) BB_40_OPR4," ).append("\n"); 
		query.append("							  MAX(DECODE(ROW_NUM,4,STWG_20,0)) STWG_20_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,STWG_2H,0)) STWG_2H_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,STWG_40,0)) STWG_40_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,STWG_4H,0)) STWG_4H_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,4,STWG_45,0)) STWG_45_OPR4," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,OPR,0))   OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,DG_20,0)) DG_20_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,DG_2H,0)) DG_2H_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,DG_40,0)) DG_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,DG_4H,0)) DG_4H_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,DG_45,0)) DG_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,RF_20,0)) RF_20_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,RF_2H,0)) RF_2H_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,RF_40,0)) RF_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,RF_4H,0)) RF_4H_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,RF_45,0)) RF_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,AK_20,0)) AK_20_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,AK_40,0)) AK_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,AK_4H,0)) AK_4H_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,AK_45,0)) AK_45_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,BB_20,0)) BB_20_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,BB_40,0)) BB_40_OPR5," ).append("\n"); 
		query.append("							  MAX(DECODE(ROW_NUM,5,STWG_20,0)) STWG_20_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,STWG_2H,0)) STWG_2H_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,STWG_40,0)) STWG_40_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,STWG_4H,0)) STWG_4H_OPR5," ).append("\n"); 
		query.append("                              MAX(DECODE(ROW_NUM,5,STWG_45,0)) STWG_45_OPR5" ).append("\n"); 
		query.append("                       FROM ( SELECT POD," ).append("\n"); 
		query.append("                                     POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                     POD_YD_CD," ).append("\n"); 
		query.append("                                     OPR," ).append("\n"); 
		query.append("                                     MLB," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) DG_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) DG_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) DG_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END),0)) DG_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(DCGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) DG_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) RF_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) RF_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) RF_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END),0)) RF_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(RC_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) RF_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(AWK_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) AK_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(AWK_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) AK_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(AWK_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END),0)) AK_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(AWK_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) AK_45," ).append("\n"); 
		query.append("                                     SUM(DECODE(BB_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) BB_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(BB_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',0,1),0)) BB_40," ).append("\n"); 
		query.append("									 SUM(DECODE(STWG_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0)) STWG_20," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'3',1,0),0)) STWG_2H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,0),0)) STWG_40," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'5',1,CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE 0 END),0)) STWG_4H," ).append("\n"); 
		query.append("                                     SUM(DECODE(STWG_CGO_FLG,'Y',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0)) STWG_45," ).append("\n"); 
		query.append("                                     MIN(ROW_NUM) ROW_NUM" ).append("\n"); 
		query.append("                              FROM ( SELECT DISTINCT " ).append("\n"); 
		query.append("                                            POD," ).append("\n"); 
		query.append("                                            POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                            POD_YD_CD," ).append("\n"); 
		query.append("                                            OPR," ).append("\n"); 
		query.append("                                            MLB," ).append("\n"); 
		query.append("                                            BKG_NO," ).append("\n"); 
		query.append("                                            CNTR_NO," ).append("\n"); 
		query.append("                                            DCGO_FLG," ).append("\n"); 
		query.append("                                            RC_FLG," ).append("\n"); 
		query.append("                                            AWK_CGO_FLG," ).append("\n"); 
		query.append("                                            BB_CGO_FLG," ).append("\n"); 
		query.append("											STWG_CGO_FLG," ).append("\n"); 
		query.append("                                            CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                            ROW_NUM," ).append("\n"); 
		query.append("                                            CNTR_RN" ).append("\n"); 
		query.append("                                     FROM   ( SELECT D.POD_CD   POD," ).append("\n"); 
		query.append("                                                     D.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                                     D.POD_YD_CD," ).append("\n"); 
		query.append("                                                     D.CRR_CD   OPR," ).append("\n"); 
		query.append("                                                     D.MLB_CD   MLB," ).append("\n"); 
		query.append("                                                     DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.BKG_NO, D.PRNR_BKG_REF_NO) BKG_NO," ).append("\n"); 
		query.append("                                                     DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.CNTR_NO, D.PRNR_CNTR_REF_NO) CNTR_NO," ).append("\n"); 
		query.append("                                                     D.DCGO_FLG," ).append("\n"); 
		query.append("                                                     D.RC_FLG," ).append("\n"); 
		query.append("                                                     D.AWK_CGO_FLG," ).append("\n"); 
		query.append("                                                     D.BB_CGO_FLG," ).append("\n"); 
		query.append("													 D.STWG_CGO_FLG," ).append("\n"); 
		query.append("                                                     D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                                     ( CASE WHEN D.CRR_CD = @[qty1]    THEN 1" ).append("\n"); 
		query.append("                                            			 					WHEN D.CRR_CD = @[qty2]  THEN 2" ).append("\n"); 
		query.append("                                            			 					WHEN D.CRR_CD = @[qty3]  THEN 3" ).append("\n"); 
		query.append("                                            			 					WHEN D.CRR_CD = @[qty4]  THEN 4" ).append("\n"); 
		query.append("                                            			 					WHEN D.CRR_CD = @[qty5]  THEN 5" ).append("\n"); 
		query.append("                                                       END) ROW_NUM," ).append("\n"); 
		query.append("                                                     DECODE(DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.CNTR_NO, D.PRNR_CNTR_REF_NO),NULL,1,ROW_NUMBER() OVER (PARTITION BY D.CRR_CD, DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.CNTR_NO, D.PRNR_CNTR_REF_NO), D.CNTR_SEQ ORDER BY DECODE(H.BKG_SHPR_OWNR_FLG, 'Y', D.BKG_NO, D.PRNR_BKG_REF_NO))) CNTR_RN" ).append("\n"); 
		query.append("                                              FROM   OPF_CGO_BKG_FCAST H, OPF_CGO_BKG_FCAST_CNTR D" ).append("\n"); 
		query.append("                              			 					WHERE  H.VSL_CD                    = @[vsl_cd]" ).append("\n"); 
		query.append("                              			 					AND    H.SKD_VOY_NO                = @[skd_voy_no]" ).append("\n"); 
		query.append("                              			 					AND    H.SKD_DIR_CD                = @[skd_dir_cd]" ).append("\n"); 
		query.append("                              			 					AND    H.YD_CD||H.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                                              AND    H.VSL_CD            = D.VSL_CD" ).append("\n"); 
		query.append("                                              AND    H.SKD_VOY_NO        = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                                              AND    H.SKD_DIR_CD        = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                              AND    H.BKG_SHPR_OWNR_FLG = D.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append("                                              AND    H.CRR_CD            = D.CRR_CD" ).append("\n"); 
		query.append("                                              AND    H.YD_CD             = D.YD_CD" ).append("\n"); 
		query.append("                                              AND    H.POL_CLPT_IND_SEQ  = D.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                              AND    D.CBF_DP_CD         = 'S'" ).append("\n"); 
		query.append("                                              AND    D.CRR_CD IN ( @[qty1], @[qty2], @[qty3], @[qty4], @[qty5] )" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("					   AND	   D.POD_CD||D.POD_CLPT_IND_SEQ LIKE @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mlb_cd} != '')" ).append("\n"); 
		query.append("					   AND	   D.MLB_CD LIKE @[mlb_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                  			      AND    CASE WHEN @[dcgo_flg] IS NULL AND @[rc_flg] IS NULL AND @[awk_cgo_flg] IS NULL AND @[bb_cgo_flg] IS NULL AND @[stwg_cgo_flg] IS NULL THEN 1 " ).append("\n"); 
		query.append("                                                          ELSE DECODE(D.DCGO_FLG,@[dcgo_flg],1,0)+DECODE(D.RC_FLG,@[rc_flg],1,0)+DECODE(D.AWK_CGO_FLG,@[awk_cgo_flg],1,0)+DECODE(D.BB_CGO_FLG,@[bb_cgo_flg],1,0)+DECODE(DECODE(D.STWG_CD,NULL,'N','Y'),@[stwg_cgo_flg],1,0)" ).append("\n"); 
		query.append("                                                     END  >=1 )" ).append("\n"); 
		query.append("                                     WHERE CNTR_RN = 1 )" ).append("\n"); 
		query.append("                              GROUP BY POD, POD_CLPT_IND_SEQ, POD_YD_CD, OPR, MLB )" ).append("\n"); 
		query.append("                       GROUP BY POD, POD_CLPT_IND_SEQ, POD_YD_CD, MLB )" ).append("\n"); 
		query.append("               GROUP BY CUBE(POD||POD_CLPT_IND_SEQ||POD_YD_CD, MLB) ) A," ).append("\n"); 
		query.append("               ( SELECT V.VPS_PORT_CD PORT, V.CLPT_IND_SEQ, V.CLPT_SEQ SEQ" ).append("\n"); 
		query.append("                 FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                 WHERE  V.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                 AND    V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                 AND    V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                 AND    V.CLPT_SEQ   > ( SELECT CLPT_SEQ" ).append("\n"); 
		query.append("                                         FROM   VSK_VSL_PORT_SKD R" ).append("\n"); 
		query.append("                                         WHERE  R.VSL_CD                = @[vsl_cd]" ).append("\n"); 
		query.append("                                         AND    R.SKD_VOY_NO            = @[skd_voy_no]" ).append("\n"); 
		query.append("                                         AND    R.SKD_DIR_CD            = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                         AND    R.YD_CD||R.CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                                         AND    ROWNUM = 1 ) ) P" ).append("\n"); 
		query.append("       WHERE NVL(C2,0) = 1" ).append("\n"); 
		query.append("       AND   SUBSTR(A.POD,1,5) = P.PORT(+) " ).append("\n"); 
		query.append("       AND   SUBSTR(A.POD,6,1) = P.CLPT_IND_SEQ(+))" ).append("\n"); 
		query.append("ORDER BY SEQ, DECODE(POD,'G.Total','ZZZZZ',SUBSTR(POD,1,5)),DECODE(POD,'','ZZZZZ',SUBSTR(POD,12,2)), DECODE(NVL(MLB,'YYY'),'S.Total','ZZZ',NVL(MLB,'YYY')) ASC" ).append("\n"); 

	}
}