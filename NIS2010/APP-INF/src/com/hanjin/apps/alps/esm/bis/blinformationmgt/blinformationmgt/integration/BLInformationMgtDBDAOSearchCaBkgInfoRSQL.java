/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtDBDAOSearchCaBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.22 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLInformationMgtDBDAOSearchCaBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BLInformationMgtDBDAOSearchCaBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration").append("\n"); 
		query.append("FileName : BLInformationMgtDBDAOSearchCaBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("BKG.BL_NO||BKG.BL_NO_TP||BKG.BL_TP_CD BL_NO," ).append("\n"); 
		query.append("(SELECT MIN(CORR_NO)" ).append("\n"); 
		query.append("FROM BIS_CORRECTION" ).append("\n"); 
		query.append("WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND CORR_NO NOT IN ('TMP0000001', '0000000001')) CA_NO," ).append("\n"); 
		query.append("BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("TO_CHAR((  SELECT SKD.VPS_ETA_DT" ).append("\n"); 
		query.append("FROM BIS_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND ( VVD.BKG_NO, VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ ) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT VVD1.BKG_NO" ).append("\n"); 
		query.append(", SUBSTR(MIN(VVD1.VSL_PRE_PST_CD||VVD1.VSL_SEQ),1,1)" ).append("\n"); 
		query.append(", SUBSTR(MIN(VVD1.VSL_PRE_PST_CD||VVD1.VSL_SEQ),2)" ).append("\n"); 
		query.append("FROM BIS_VVD VVD1" ).append("\n"); 
		query.append("WHERE VVD.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("GROUP BY VVD1.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("), 'YYYY-MM-DD') SAILED_VVD," ).append("\n"); 
		query.append("BKG.POR_CD," ).append("\n"); 
		query.append("SUBSTR(BKG.POR_NOD_CD, 6, 2) POR_NOD_CD," ).append("\n"); 
		query.append("BKG.POL_CD," ).append("\n"); 
		query.append("SUBSTR(BKG.POL_NOD_CD, 6, 2) POL_NOD_CD," ).append("\n"); 
		query.append("BKG.POD_CD," ).append("\n"); 
		query.append("SUBSTR(BKG.POD_NOD_CD, 6, 2) POD_NOD_CD," ).append("\n"); 
		query.append("BKG.DEL_CD," ).append("\n"); 
		query.append("SUBSTR(BKG.DEL_NOD_CD, 6, 2) DEL_NOD_CD," ).append("\n"); 
		query.append("CUST.CUST_CNT_CD," ).append("\n"); 
		query.append("CUST.CUST_SEQ," ).append("\n"); 
		query.append("CUST.CUST_NM" ).append("\n"); 
		query.append("FROM BIS_BOOKING BKG" ).append("\n"); 
		query.append(", BIS_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO          = CUST.BKG_NO" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND BKG.BKG_NO = (  SELECT CASE" ).append("\n"); 
		query.append("WHEN @[bkg_no] is not null THEN @[bkg_no]" ).append("\n"); 
		query.append("WHEN @[bl_no] is not null THEN (" ).append("\n"); 
		query.append("CASE WHEN LENGTHB(@[bl_no]) = 13 THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM BIS_BOOKING" ).append("\n"); 
		query.append("WHERE BL_NO    = SUBSTR(@[bl_no], 1, 12)" ).append("\n"); 
		query.append("AND BL_NO_TP = SUBSTR(@[bl_no], 13, 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN LENGTHB(@[bl_no]) = 14 THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM BIS_BOOKING" ).append("\n"); 
		query.append("WHERE BL_NO    = SUBSTR(@[bl_no], 1, 12)" ).append("\n"); 
		query.append("AND BL_NO_TP = SUBSTR(@[bl_no], 13, 1)" ).append("\n"); 
		query.append("AND BL_TP_CD = SUBSTR(@[bl_no], 14, 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM BIS_BOOKING" ).append("\n"); 
		query.append("WHERE BL_NO = SUBSTR(@[bl_no], 1, 12)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN @[ca_no] is not null THEN ( SELECT BKG_NO" ).append("\n"); 
		query.append("FROM BIS_CORRECTION" ).append("\n"); 
		query.append("WHERE CORR_NO = @[ca_no])" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}