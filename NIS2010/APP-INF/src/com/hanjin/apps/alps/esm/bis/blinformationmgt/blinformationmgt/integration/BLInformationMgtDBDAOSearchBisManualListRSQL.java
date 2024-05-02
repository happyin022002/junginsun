/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLInformationMgtDBDAOSearchBisManualListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.12
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.12.12 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLInformationMgtDBDAOSearchBisManualListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLInformationMgtDBDAOSearchBisManualListRSQL.Query
	  * </pre>
	  */
	public BLInformationMgtDBDAOSearchBisManualListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration").append("\n"); 
		query.append("FileName : BLInformationMgtDBDAOSearchBisManualListRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX(XAK3BKG_BOOKING,BK) */" ).append("\n"); 
		query.append("    BK.BKG_NO," ).append("\n"); 
		query.append("    BL.BDR_FLG," ).append("\n"); 
		query.append("    BL.BIS_SYS_FLG," ).append("\n"); 
		query.append("    ISS.OBL_ISS_FLG," ).append("\n"); 
		query.append("    ISS.OBL_PRN_FLG," ).append("\n"); 
		query.append("    ISS.OBL_RLSE_FLG," ).append("\n"); 
		query.append("    ISS.OBL_SRND_FLG," ).append("\n"); 
		query.append("    ISS.OBL_RDEM_FLG," ).append("\n"); 
		query.append("    NVL((SELECT 'Y' FROM BKG_CHG_RT WHERE BKG_NO = BK.BKG_NO AND ROWNUM = 1),'N') CHG_FLG" ).append("\n"); 
		query.append(" FROM BKG_BOOKING BK, BKG_BL_DOC BL, BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE BK.BKG_CRE_DT >= TO_DATE(@[from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND   BK.BKG_CRE_DT <= TO_DATE(@[to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("AND BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("AND ( BL.BDR_FLG ='Y' OR ISS.OBL_ISS_FLG ='Y' OR ISS.OBL_PRN_FLG ='Y' OR ISS.OBL_RLSE_FLG ='Y' OR ISS.OBL_SRND_FLG ='Y' OR ISS.OBL_RDEM_FLG='Y'" ).append("\n"); 
		query.append("OR EXISTS( SELECT 'Y' FROM BKG_CHG_RT WHERE BKG_NO = BK.BKG_NO AND ROWNUM =1))" ).append("\n"); 
		query.append("AND NOT EXISTS ( SELECT 'Y' FROM BIS_BOOKING WHERE BKG_NO = BK.BKG_NO )" ).append("\n"); 

	}
}