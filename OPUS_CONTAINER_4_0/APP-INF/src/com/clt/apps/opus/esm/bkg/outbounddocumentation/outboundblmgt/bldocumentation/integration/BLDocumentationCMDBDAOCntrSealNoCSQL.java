/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrSealNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCntrSealNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrSealNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrSealNoCSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("INSERT INTO BKG_CNTR_SEAL_NO_HIS (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",   CORR_NO" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_SEAL_SEQ" ).append("\n"); 
		query.append(",	CNTR_SEAL_NO" ).append("\n"); 
		query.append(",	SEAL_PTY_NM" ).append("\n"); 
		query.append(",	SEAL_PTY_TP_CD" ).append("\n"); 
		query.append(",	SEAL_KND_CD" ).append("\n"); 
		query.append(",	SEAL_INP_TP_CD" ).append("\n"); 
		query.append(",	PRN_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",   'TMP0000001'" ).append("\n"); 
		query.append(",   @[cntr_no]" ).append("\n"); 
		query.append(",   (NVL((SELECT MAX(CNTR_SEAL_SEQ)" ).append("\n"); 
		query.append("            FROM BKG_CNTR_SEAL_NO_HIS" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no] AND CORR_NO='TMP0000001' AND CNTR_NO=@[cntr_no]), 0)+1)" ).append("\n"); 
		query.append(",   @[cntr_seal_no]" ).append("\n"); 
		query.append(",   @[seal_pty_nm]" ).append("\n"); 
		query.append(",   @[seal_pty_tp_cd]" ).append("\n"); 
		query.append(",   @[seal_knd_cd]" ).append("\n"); 
		query.append(",	@[seal_inp_tp_cd]" ).append("\n"); 
		query.append(",   DECODE(@[prn_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append(",   sysdate" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append(",   sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("INSERT INTO BKG_CNTR_SEAL_NO (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_SEAL_SEQ" ).append("\n"); 
		query.append(",	CNTR_SEAL_NO" ).append("\n"); 
		query.append(",	SEAL_PTY_NM" ).append("\n"); 
		query.append(",	SEAL_PTY_TP_CD" ).append("\n"); 
		query.append(",	SEAL_KND_CD" ).append("\n"); 
		query.append(",	SEAL_INP_TP_CD" ).append("\n"); 
		query.append(",	PRN_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",   @[cntr_no]" ).append("\n"); 
		query.append(",   (NVL((SELECT MAX(CNTR_SEAL_SEQ)" ).append("\n"); 
		query.append("            FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("            WHERE BKG_NO=@[bkg_no] AND CNTR_NO=@[cntr_no]), 0)+1)" ).append("\n"); 
		query.append(",   @[cntr_seal_no]" ).append("\n"); 
		query.append(",   @[seal_pty_nm]" ).append("\n"); 
		query.append(",   @[seal_pty_tp_cd]" ).append("\n"); 
		query.append(",   @[seal_knd_cd]" ).append("\n"); 
		query.append(",	@[seal_inp_tp_cd]" ).append("\n"); 
		query.append(",   DECODE(@[prn_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append(",   sysdate" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append(",   sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}