/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrSealNoUSQL.java
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

public class BLDocumentationCMDBDAOCntrSealNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrSealNoUSQL(){
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
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrSealNoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CNTR_SEAL_NO_HIS" ).append("\n"); 
		query.append("SET CNTR_SEAL_NO   = @[cntr_seal_no]" ).append("\n"); 
		query.append(",	SEAL_PTY_NM    = @[seal_pty_nm]" ).append("\n"); 
		query.append(",	SEAL_PTY_TP_CD = @[seal_pty_tp_cd]" ).append("\n"); 
		query.append(",	SEAL_KND_CD    = @[seal_knd_cd]" ).append("\n"); 
		query.append(",   SEAL_INP_TP_CD = @[seal_inp_tp_cd]" ).append("\n"); 
		query.append(",	PRN_FLG        = DECODE(@[prn_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT         = sysdate" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    CNTR_SEAL_SEQ = @[cntr_seal_seq]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE BKG_CNTR_SEAL_NO " ).append("\n"); 
		query.append("SET CNTR_SEAL_NO   = @[cntr_seal_no]" ).append("\n"); 
		query.append(",	SEAL_PTY_NM    = @[seal_pty_nm]" ).append("\n"); 
		query.append(",	SEAL_PTY_TP_CD = @[seal_pty_tp_cd]" ).append("\n"); 
		query.append(",	SEAL_KND_CD    = @[seal_knd_cd]" ).append("\n"); 
		query.append(",   SEAL_INP_TP_CD = @[seal_inp_tp_cd]" ).append("\n"); 
		query.append(",	PRN_FLG        = DECODE(@[prn_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT         = sysdate" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    CNTR_SEAL_SEQ = @[cntr_seal_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}