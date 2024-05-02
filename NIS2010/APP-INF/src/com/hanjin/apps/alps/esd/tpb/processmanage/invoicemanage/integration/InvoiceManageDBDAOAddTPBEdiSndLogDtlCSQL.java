/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InvoiceManageDBDAOAddTPBEdiSndLogDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.18
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.04.18 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOAddTPBEdiSndLogDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddTPBEdiSndLogDtl
	  * </pre>
	  */
	public InvoiceManageDBDAOAddTPBEdiSndLogDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_edi_snd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("log_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOAddTPBEdiSndLogDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO TPB_EDI_SND_LOG_DTL" ).append("\n"); 
		query.append("(   N3PTY_EDI_SND_IND_CD" ).append("\n"); 
		query.append("   ,SND_DT" ).append("\n"); 
		query.append("   ,FLT_FILE_REF_NO" ).append("\n"); 
		query.append("   ,N3PTY_EDI_SND_SEQ" ).append("\n"); 
		query.append("   ,LOG_DTL_SEQ" ).append("\n"); 
		query.append("   ,N3PTY_NO" ).append("\n"); 
		query.append("   ,N3PTY_INV_NO" ).append("\n"); 
		query.append("   ,EDI_SND_MSG" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("     @[n3pty_edi_snd_ind_cd]" ).append("\n"); 
		query.append("    ,sysdate" ).append("\n"); 
		query.append("    ,@[flt_file_ref_no]" ).append("\n"); 
		query.append("    ,(  SELECT NVL(MAX(N3PTY_EDI_SND_SEQ),0)+1" ).append("\n"); 
		query.append("        FROM   TPB_EDI_SND_LOG_DTL" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    N3PTY_EDI_SND_IND_CD = @[n3pty_edi_snd_ind_cd]" ).append("\n"); 
		query.append("        AND    FLT_FILE_REF_NO = @[flt_file_ref_no]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    ,@[log_dtl_seq]" ).append("\n"); 
		query.append("    ,@[n3pty_no]" ).append("\n"); 
		query.append("    ,@[n3pty_inv_no]" ).append("\n"); 
		query.append("    ,@[edi_snd_msg]" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}