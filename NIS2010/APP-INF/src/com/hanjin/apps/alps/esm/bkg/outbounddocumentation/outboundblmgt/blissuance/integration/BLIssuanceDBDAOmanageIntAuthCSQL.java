/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAOmanageIntAuthCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOmanageIntAuthCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * manageIntAuth
	  * </pre>
	  */
	public BLIssuanceDBDAOmanageIntAuthCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOmanageIntAuthCSQL").append("\n"); 
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
		query.append("#if (${buttonType} == 'btn_t11InternetAUTH')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	INSERT INTO BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("	(BKG_NO," ).append("\n"); 
		query.append("	INFO_SEQ," ).append("\n"); 
		query.append("	AUTH_DT," ).append("\n"); 
		query.append("	AUTH_OFC_CD," ).append("\n"); 
		query.append("	AUTH_USR_ID," ).append("\n"); 
		query.append("	SHPR_CNT_CD," ).append("\n"); 
		query.append("	SHPR_SEQ," ).append("\n"); 
		query.append("	CNEE_CNT_CD," ).append("\n"); 
		query.append("	CNEE_SEQ," ).append("\n"); 
		query.append("	NTFY_CNT_CD," ).append("\n"); 
		query.append("	NTFY_SEQ," ).append("\n"); 
		query.append("	FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("	FRT_FWRD_SEQ," ).append("\n"); 
		query.append("	ANTFY_CNT_CD," ).append("\n"); 
		query.append("	ANTFY_SEQ," ).append("\n"); 
		query.append("	VSL_CD," ).append("\n"); 
		query.append("	SKD_VOY_NO," ).append("\n"); 
		query.append("	SKD_DIR_CD," ).append("\n"); 
		query.append("	BL_OBRD_DT," ).append("\n"); 
		query.append("	BL_NO," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("#if (${ser_no} != '') " ).append("\n"); 
		query.append("	OBL_INTER_SER_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	UPD_USR_ID )" ).append("\n"); 
		query.append("	    SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("	    (SELECT NVL( MAX(INFO_SEQ), 0) +1 FROM BKG_INET_BL_PRN_AUTH WHERE BKG_NO = @[bkg_no])," ).append("\n"); 
		query.append("	    SYSDATE," ).append("\n"); 
		query.append("	    @[upd_office]," ).append("\n"); 
		query.append("	    @[upd_usr_id], " ).append("\n"); 
		query.append("	    SHPR.CUST_CNT_CD," ).append("\n"); 
		query.append("	    SHPR.CUST_SEQ," ).append("\n"); 
		query.append("	    CNEE.CUST_CNT_CD," ).append("\n"); 
		query.append("	    CNEE.CUST_SEQ," ).append("\n"); 
		query.append("	    NTFY.CUST_CNT_CD," ).append("\n"); 
		query.append("	    NTFY.CUST_SEQ," ).append("\n"); 
		query.append("	    FWRD.CUST_CNT_CD," ).append("\n"); 
		query.append("	    FWRD.CUST_SEQ," ).append("\n"); 
		query.append("	    ANTFY.CUST_CNT_CD," ).append("\n"); 
		query.append("	    ANTFY.CUST_SEQ," ).append("\n"); 
		query.append("	    BKG.VSL_CD," ).append("\n"); 
		query.append("	    BKG.SKD_VOY_NO," ).append("\n"); 
		query.append("	    BKG.SKD_DIR_CD," ).append("\n"); 
		query.append("	    DOC.BL_OBRD_DT," ).append("\n"); 
		query.append("	    BKG.BL_NO," ).append("\n"); 
		query.append("	    @[upd_usr_id]," ).append("\n"); 
		query.append("#if (${ser_no} != '') " ).append("\n"); 
		query.append("		@[ser_no]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	    @[upd_usr_id]" ).append("\n"); 
		query.append("	    FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("	    BKG_BL_DOC DOC," ).append("\n"); 
		query.append("	    BKG_CUSTOMER SHPR," ).append("\n"); 
		query.append("	    BKG_CUSTOMER CNEE," ).append("\n"); 
		query.append("	    BKG_CUSTOMER NTFY," ).append("\n"); 
		query.append("	    BKG_CUSTOMER FWRD," ).append("\n"); 
		query.append("	    BKG_CUSTOMER ANTFY" ).append("\n"); 
		query.append("	    WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	    AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("	    AND BKG.BKG_NO = SHPR.BKG_NO " ).append("\n"); 
		query.append("	    AND SHPR.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("	    AND BKG.BKG_NO = CNEE.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND CNEE.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("	    AND BKG.BKG_NO = NTFY.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND NTFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("	    AND BKG.BKG_NO = FWRD.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND FWRD.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("	    AND BKG.BKG_NO = ANTFY.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND ANTFY.BKG_CUST_TP_CD(+) = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("	SET " ).append("\n"); 
		query.append("		DELT_FLG = 'Y'," ).append("\n"); 
		query.append("		DELT_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("		DELT_OFC_CD = @[upd_office], " ).append("\n"); 
		query.append("		DELT_DT = SYSDATE" ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	--AND INFO_SEQ = (SELECT MAX(INFO_SEQ) FROM BKG_INET_BL_PRN_AUTH	WHERE BKG_NO = [bkg_no])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}