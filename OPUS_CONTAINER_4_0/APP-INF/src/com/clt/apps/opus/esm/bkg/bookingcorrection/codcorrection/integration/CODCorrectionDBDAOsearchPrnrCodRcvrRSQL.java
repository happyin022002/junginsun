/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchPrnrCodRcvrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.05.18 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchPrnrCodRcvrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mail 보내고 받는 사람 정보 조회
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchPrnrCodRcvrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhnd_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchPrnrCodRcvrRSQL").append("\n"); 
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
		query.append("SELECT (SELECT PIC_EML" ).append("\n"); 
		query.append("FROM VSK_LANE_PIC EML" ).append("\n"); 
		query.append("WHERE SLAN_CD = (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD     = SUBSTR(@[rhnd_vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[rhnd_vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[rhnd_vvd], 9, 1))" ).append("\n"); 
		query.append("AND RGN_SHP_OPR_CD = COD.RGN_CD" ).append("\n"); 
		query.append("AND (PIC_VSL_DESC IS NULL OR PIC_VSL_DESC LIKE '%'||SUBSTR(@[rhnd_vvd], 1, 4)||'%')" ).append("\n"); 
		query.append("AND LANE_PIC_TP_CD = 'J'" ).append("\n"); 
		query.append("AND ROWNUM         = 1) TO_EML" ).append("\n"); 
		query.append(", USR_EML CC_EML" ).append("\n"); 
		query.append(", (SELECT PIC_EML" ).append("\n"); 
		query.append("FROM VSK_LANE_PIC EML" ).append("\n"); 
		query.append("WHERE SLAN_CD = (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD     = SUBSTR(@[rhnd_vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[rhnd_vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[rhnd_vvd], 9, 1))" ).append("\n"); 
		query.append("AND RGN_SHP_OPR_CD = COD.RGN_CD" ).append("\n"); 
		query.append("AND (PIC_VSL_DESC IS NULL OR PIC_VSL_DESC LIKE '%'||SUBSTR(@[rhnd_vvd], 1, 4)||'%')" ).append("\n"); 
		query.append("AND LANE_PIC_TP_CD = 'I'" ).append("\n"); 
		query.append("AND ROWNUM         = 1) FROM_EML" ).append("\n"); 
		query.append(", (SELECT GLOBAL_NAME FROM GLOBAL_NAME) GLOBAL_NAME" ).append("\n"); 
		query.append("FROM COM_USER USR, BKG_COD COD" ).append("\n"); 
		query.append("WHERE UPPER(USR.USR_ID) = UPPER(@[usr_id])" ).append("\n"); 
		query.append("AND COD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND COD.COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 

	}
}