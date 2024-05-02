/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchEdiHistoryKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.01 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchEdiHistoryKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur 수신 키값 조회
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchEdiHistoryKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msgTpId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("keyType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("portCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchEdiHistoryKeyRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[keyType] = 'ANR' THEN" ).append("\n"); 
		query.append("@[msgTpId] || TO_CHAR(SYSDATE, 'YYMMDD') || LTRIM(TO_CHAR(BKG_CSTMS_EUR_DG_SEQ.NEXTVAL,'009'))" ).append("\n"); 
		query.append("|| (" ).append("\n"); 
		query.append("SELECT LPAD(NVL(MAX(SUBSTR(MSG_SND_NO, -2, 2)), 0) + 1, 2, '0')" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_DG_SND" ).append("\n"); 
		query.append("WHERE EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("AND   EUR_DG_DECL_TP_CD = @[dType]" ).append("\n"); 
		query.append("AND   VSL_CD      = SUBSTR(@[vvdCd], 1, 4)" ).append("\n"); 
		query.append("AND   SKD_VOY_NO  = SUBSTR(@[vvdCd], 5, 4)" ).append("\n"); 
		query.append("AND   SKD_DIR_CD  = SUBSTR(@[vvdCd], 9, 1)" ).append("\n"); 
		query.append("AND   PORT_CD     = @[portCd]" ).append("\n"); 
		query.append("AND   'HANSHI'    = SUBSTR(MSG_SND_NO, 1, 6)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN @[keyType] = 'CTA' THEN" ).append("\n"); 
		query.append("@[msgTpId] || TO_CHAR(SYSDATE, 'YYYYMMDD') || LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'))" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("@[msgTpId] || LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'0000009'))" ).append("\n"); 
		query.append("END KEY_VAL" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}