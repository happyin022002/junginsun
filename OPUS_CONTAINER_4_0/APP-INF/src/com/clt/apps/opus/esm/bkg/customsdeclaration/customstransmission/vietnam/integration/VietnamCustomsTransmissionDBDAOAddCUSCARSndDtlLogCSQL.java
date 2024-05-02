/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOAddCUSCARSndDtlLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOAddCUSCARSndDtlLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCUSCARSndDtlLog
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOAddCUSCARSndDtlLogCSQL(){
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
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vn_mf_snd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_snd_msg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOAddCUSCARSndDtlLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_VN_SND_LOG_DTL " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     VN_MF_SND_IND_CD" ).append("\n"); 
		query.append("    ,MF_SND_DT" ).append("\n"); 
		query.append("    ,FLT_FILE_REF_NO" ).append("\n"); 
		query.append("    ,MF_SND_SEQ" ).append("\n"); 
		query.append("    ,LOG_DTL_SEQ" ).append("\n"); 
		query.append("    ,EDI_SND_MSG" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("     @[vn_mf_snd_ind_cd]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[flt_file_ref_no]" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT NVL(MAX(MF_SND_SEQ),0)" ).append("\n"); 
		query.append("        FROM   BKG_CSTMS_VN_SND_LOG" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    VN_MF_SND_IND_CD = @[vn_mf_snd_ind_cd]" ).append("\n"); 
		query.append("        AND    FLT_FILE_REF_NO = @[flt_file_ref_no]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    ,@[log_dtl_seq]" ).append("\n"); 
		query.append("    ,@[edi_snd_msg]" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}