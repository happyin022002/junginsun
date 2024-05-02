/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmLseCoYdDBDAOAddMdmLseCoYdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmLseCoYdDBDAOAddMdmLseCoYdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_LSE_CO_YD 입력
	  * 
	  * <Change History>
	  * 1	2009.09.08	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public ReceiveQueueMdmLseCoYdDBDAOAddMdmLseCoYdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onf_hir_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq19",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_yd_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq18",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_pic_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_co_vndr_seq10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmLseCoYdDBDAOAddMdmLseCoYdCSQL").append("\n"); 
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
		query.append("/* ReceiveQueueMdmLseCoYdDBDAO - addMDM_LSE_CO_YD() */" ).append("\n"); 
		query.append("INSERT INTO MDM_LSE_CO_YD" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    LSE_CO_YD_CD" ).append("\n"); 
		query.append("    ,LSE_CO_YD_NM" ).append("\n"); 
		query.append("    ,ONF_HIR_YD_FLG" ).append("\n"); 
		query.append("    ,YD_ADDR" ).append("\n"); 
		query.append("    ,INTL_PHN_NO" ).append("\n"); 
		query.append("    ,PHN_NO" ).append("\n"); 
		query.append("    ,FAX_NO" ).append("\n"); 
		query.append("    ,YD_PIC_NM" ).append("\n"); 
		query.append("    ,YD_EML" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ1" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ2" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ3" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ4" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ5" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ6" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ7" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ8" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ9" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ10" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,DELT_FLG" ).append("\n"); 
		query.append("    ,EAI_EVNT_DT" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ11" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ12" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ13" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ14" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ15" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ16" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ17" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ18" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ19" ).append("\n"); 
		query.append("    ,LSE_CO_VNDR_SEQ20" ).append("\n"); 
		query.append("	,EAI_IF_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[lse_co_yd_cd]" ).append("\n"); 
		query.append("    ,@[lse_co_yd_nm]" ).append("\n"); 
		query.append("    ,@[onf_hir_yd_flg]" ).append("\n"); 
		query.append("    ,@[yd_addr]" ).append("\n"); 
		query.append("    ,@[intl_phn_no]" ).append("\n"); 
		query.append("    ,@[phn_no]" ).append("\n"); 
		query.append("    ,@[fax_no]" ).append("\n"); 
		query.append("    ,@[yd_pic_nm]" ).append("\n"); 
		query.append("    ,@[yd_eml]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq1]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq2]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq3]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq4]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq5]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq6]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq7]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq8]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq9]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq10]" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,to_date(@[cre_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,to_date(@[upd_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("    ,@[delt_flg]" ).append("\n"); 
		query.append("    ,TO_DATE(@[eai_evnt_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq11]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq12]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq13]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq14]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq15]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq16]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq17]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq18]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq19]" ).append("\n"); 
		query.append("    ,@[lse_co_vndr_seq20]" ).append("\n"); 
		query.append("	,@[eai_if_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}