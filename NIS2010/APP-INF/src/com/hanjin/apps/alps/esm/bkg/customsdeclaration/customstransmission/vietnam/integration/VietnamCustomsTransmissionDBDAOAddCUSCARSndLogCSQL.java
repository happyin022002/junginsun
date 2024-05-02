/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOAddCUSCARSndLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.30
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.30 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOAddCUSCARSndLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCUSCARSndLog
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOAddCUSCARSndLogCSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vn_cstms_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOAddCUSCARSndLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_VN_SND_LOG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     VN_MF_SND_IND_CD" ).append("\n"); 
		query.append("    ,MF_SND_DT" ).append("\n"); 
		query.append("    ,FLT_FILE_REF_NO" ).append("\n"); 
		query.append("    ,MF_SND_SEQ" ).append("\n"); 
		query.append("    ,VSL_CD" ).append("\n"); 
		query.append("    ,SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,POL_CD" ).append("\n"); 
		query.append("    ,POD_CD" ).append("\n"); 
		query.append("    ,VN_CSTMS_BND_CD" ).append("\n"); 
		query.append("    ,OFC_CD" ).append("\n"); 
		query.append("    ,BKG_NO" ).append("\n"); 
		query.append("    ,CNTR_NO" ).append("\n"); 
		query.append("    ,MF_RCVR_USR_ID" ).append("\n"); 
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
		query.append("        SELECT NVL(MAX(MF_SND_SEQ),0) + 1" ).append("\n"); 
		query.append("        FROM   BKG_CSTMS_VN_SND_LOG" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    VN_MF_SND_IND_CD = @[vn_mf_snd_ind_cd]" ).append("\n"); 
		query.append("        AND    FLT_FILE_REF_NO = @[flt_file_ref_no]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    ,SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("    ,SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("    ,SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("    ,@[pol_cd]" ).append("\n"); 
		query.append("    ,@[pod_cd]" ).append("\n"); 
		query.append("    ,@[vn_cstms_bnd_cd]" ).append("\n"); 
		query.append("    ,@[ofc_cd]" ).append("\n"); 
		query.append("    ,@[bkg_no]" ).append("\n"); 
		query.append("    ,@[cntr_no]" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}