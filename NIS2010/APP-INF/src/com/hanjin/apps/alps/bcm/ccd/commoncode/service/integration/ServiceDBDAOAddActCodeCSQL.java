/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ServiceDBDAOAddActCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOAddActCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 새로운 ACTIVITY CODE를 생성하는 쿼리
	  * </pre>
	  */
	public ServiceDBDAOAddActCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_skd_lgc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_vskd_seq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_op_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_stnd_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOAddActCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_ACTIVITY" ).append("\n"); 
		query.append("           (ACT_CD" ).append("\n"); 
		query.append("           ,ACT_NM" ).append("\n"); 
		query.append("           ,ACT_DESC" ).append("\n"); 
		query.append("		#if (${act_tp_cd} != '')" ).append("\n"); 
		query.append("           ,ACT_TP_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${full_mty_cd} != '')" ).append("\n"); 
		query.append("           ,FULL_MTY_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${bnd_vskd_seq_cd} != '')" ).append("\n"); 
		query.append("           ,BND_VSKD_SEQ_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${nod_tp_cd} != '')" ).append("\n"); 
		query.append("           ,NOD_TP_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${act_op_tp_cd} != '')" ).append("\n"); 
		query.append("           ,ACT_OP_TP_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${trsp_mod_cd} != '')" ).append("\n"); 
		query.append("           ,TRSP_MOD_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${org_dest_cd} != '')" ).append("\n"); 
		query.append("           ,ORG_DEST_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${act_flg} != '')" ).append("\n"); 
		query.append("           ,ACT_FLG" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${act_stnd_edi_sts_cd} != '')" ).append("\n"); 
		query.append("           ,ACT_STND_EDI_STS_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${cop_skd_lgc_no} != '')" ).append("\n"); 
		query.append("           ,COP_SKD_LGC_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("           ,DELT_FLG" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT)" ).append("\n"); 
		query.append("VALUES(@[act_cd]" ).append("\n"); 
		query.append("      ,@[act_nm]" ).append("\n"); 
		query.append("      ,@[act_desc]" ).append("\n"); 
		query.append("	#if (${act_tp_cd} != '')" ).append("\n"); 
		query.append("      ,@[act_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${full_mty_cd} != '')" ).append("\n"); 
		query.append("      ,@[full_mty_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${bnd_vskd_seq_cd} != '')" ).append("\n"); 
		query.append("      ,@[bnd_vskd_seq_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${nod_tp_cd} != '')" ).append("\n"); 
		query.append("      ,@[nod_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${act_op_tp_cd} != '')" ).append("\n"); 
		query.append("      ,@[act_op_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${trsp_mod_cd} != '')" ).append("\n"); 
		query.append("      ,@[trsp_mod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${org_dest_cd} != '')" ).append("\n"); 
		query.append("      ,@[org_dest_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${act_flg} != '')" ).append("\n"); 
		query.append("      ,@[act_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${act_stnd_edi_sts_cd} != '')" ).append("\n"); 
		query.append("      ,@[act_stnd_edi_sts_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cop_skd_lgc_no} != '')" ).append("\n"); 
		query.append("      ,@[cop_skd_lgc_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${delt_flg} != '')" ).append("\n"); 
		query.append("      ,@[delt_flg]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	  ,'N'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE) " ).append("\n"); 

	}
}