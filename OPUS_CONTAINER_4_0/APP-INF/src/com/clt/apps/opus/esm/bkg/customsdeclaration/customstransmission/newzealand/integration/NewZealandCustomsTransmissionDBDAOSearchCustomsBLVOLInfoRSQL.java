/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewZealandCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL").append("\n"); 
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
		query.append("SELECT '1' LOOP_IND," ).append("\n"); 
		query.append("       B.BL_NO BL_NO," ).append("\n"); 
		query.append("       B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("       '' TR_IND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD V," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       BKG_BL_DOC BD," ).append("\n"); 
		query.append("       BKG_CONTAINER BC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND V.POD_CD = @[vvd_pod_cd]" ).append("\n"); 
		query.append("   AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("   AND BD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND BC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY B.BL_NO," ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       BD.ACT_WGT," ).append("\n"); 
		query.append("       BD.WGT_UT_CD," ).append("\n"); 
		query.append("       BD.MEAS_QTY," ).append("\n"); 
		query.append("       BD.MEAS_UT_CD," ).append("\n"); 
		query.append("       B.CMDT_CD," ).append("\n"); 
		query.append("       BD.PCK_QTY," ).append("\n"); 
		query.append("       BD.PCK_TP_CD" ).append("\n"); 

	}
}