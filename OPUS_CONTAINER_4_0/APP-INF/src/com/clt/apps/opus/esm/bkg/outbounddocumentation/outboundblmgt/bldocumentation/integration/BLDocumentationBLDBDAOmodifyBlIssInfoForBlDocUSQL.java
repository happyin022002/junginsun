/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOmodifyBlIssInfoForBlDocUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.11 
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

public class BLDocumentationBLDBDAOmodifyBlIssInfoForBlDocUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBlIssInfoForBlDoc
	  * </pre>
	  */
	public BLDocumentationBLDBDAOmodifyBlIssInfoForBlDocUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("move_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_mv_tp_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("on_board_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vessel_direction",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("final_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_name",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("on_board_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_carriage_by",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOmodifyBlIssInfoForBlDocUSQL").append("\n"); 
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
		query.append("UPDATE " ).append("\n"); 
		query.append("	BKG_BL_DOC" ).append("\n"); 
		query.append("SET   " ).append("\n"); 
		query.append("	VSL_NM		= @[vessel_direction]" ).append("\n"); 
		query.append("	,PRE_VSL_NM	= @[pre_carriage_by]" ).append("\n"); 
		query.append("##	,POR_CD		= @[por_code]" ).append("\n"); 
		query.append("	,POR_NM		= @[por_name]" ).append("\n"); 
		query.append("##	,POL_CD		= @[pol_code]" ).append("\n"); 
		query.append("	,POL_NM		= @[pol_name]" ).append("\n"); 
		query.append("##	,POD_CD		= @[pod_code]" ).append("\n"); 
		query.append("	,POD_NM		= @[pod_name]" ).append("\n"); 
		query.append("##	,DEL_CD		= @[del_code]" ).append("\n"); 
		query.append("	,DEL_NM		= @[del_name]" ).append("\n"); 
		query.append("	,BL_MV_TP_NM	= @[move_type]" ).append("\n"); 
		query.append("	,FNL_DEST_NM   = @[final_dest]" ).append("\n"); 
		query.append("	,BL_OBRD_TP_CD = @[on_board_type]" ).append("\n"); 
		query.append("#if ('000000'!=${on_board_date})" ).append("\n"); 
		query.append("    ,BL_OBRD_DT		= TO_DATE(@[on_board_date],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    ,BL_OBRD_DT		= NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,UPD_USR_ID	= @[upd_usr_id]" ).append("\n"); 
		query.append("	,UPD_DT		= sysdate" ).append("\n"); 
		query.append("	,BL_MV_TP_PRN_FLG		= @[bl_mv_tp_prn_flg]" ).append("\n"); 
		query.append("	,RCV_DE_TERM_PRN_FLG	= @[rcv_de_term_prn_flg]" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}