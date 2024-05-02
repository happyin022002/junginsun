/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooAddSlotMgrVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2016.06.03 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOJooAddSlotMgrVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooAddSlotMgrVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("settle_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rel_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_weight",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_price",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_bsa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("leg_tport",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ous_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("leg_fport",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_divr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooAddSlotMgrVOCSQL").append("\n"); 
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
		query.append("INSERT INTO joo_fx_agmt (" ).append("\n"); 
		query.append("  JO_CRR_CD      " ).append("\n"); 
		query.append(",  TRD_CD         " ).append("\n"); 
		query.append(",  RLANE_CD       " ).append("\n"); 
		query.append(",  RE_DIVR_CD     " ).append("\n"); 
		query.append(",  FX_AGMT_SEQ    " ).append("\n"); 
		query.append(",  OFC_CD         " ).append("\n"); 
		query.append(",  AGMT_OFC_CD    " ).append("\n"); 
		query.append(",  AGMT_TERM_CD   " ).append("\n"); 
		query.append(",  FX_AGMT_DT     " ).append("\n"); 
		query.append(",  VSL_CD         " ).append("\n"); 
		query.append(",  SKD_VOY_NO     " ).append("\n"); 
		query.append(",  SKD_DIR_CD     " ).append("\n"); 
		query.append(",  FM_PORT_CD     " ).append("\n"); 
		query.append(",  TO_PORT_CD     " ).append("\n"); 
		query.append(",  BSA_QTY        " ).append("\n"); 
		query.append(",  BSA_PER_WGT    " ).append("\n"); 
		query.append(",  BSA_SLT_PRC    " ).append("\n"); 
		query.append(",  ATCH_FILE_ID   " ).append("\n"); 
		query.append(",  FX_AGMT_RMK    " ).append("\n"); 
		query.append(",  STL_DT         " ).append("\n"); 
		query.append(",  ACT_OVR_USD_QTY" ).append("\n"); 
		query.append(",  DELT_FLG" ).append("\n"); 
		query.append(",  PIC_USR_ID       " ).append("\n"); 
		query.append(",  CRE_DT         " ).append("\n"); 
		query.append(",  CRE_USR_ID     " ).append("\n"); 
		query.append(",  UPD_DT         " ).append("\n"); 
		query.append(",  UPD_USR_ID     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[acctg_crr_cd]" ).append("\n"); 
		query.append(",	@[trd_cd]" ).append("\n"); 
		query.append(",	@[rlane_cd] " ).append("\n"); 
		query.append(",	@[rev_divr]" ).append("\n"); 
		query.append(", NVL((SELECT MAX(NVL(FX_AGMT_SEQ,0))+1 FROM JOO_FX_AGMT WHERE TRD_CD = @[trd_cd] AND RLANE_CD = @[rlane_cd] AND JO_CRR_CD = @[acctg_crr_cd] AND RE_DIVR_CD = @[rev_divr]),1)" ).append("\n"); 
		query.append(",	@[ofc_cd]" ).append("\n"); 
		query.append(",	@[rel_ofc_cd]" ).append("\n"); 
		query.append(",	@[term]" ).append("\n"); 
		query.append(",	REPLACE(@[date_dt],'-','')" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append(",	@[leg_fport]" ).append("\n"); 
		query.append(",	@[leg_tport]" ).append("\n"); 
		query.append(",	NVL(@[jo_bsa],0)" ).append("\n"); 
		query.append(",	NVL(@[jo_weight],0)" ).append("\n"); 
		query.append(",	NVL(@[jo_price],0)" ).append("\n"); 
		query.append(",	@[atch_file_id]" ).append("\n"); 
		query.append(",	@[jo_remark]" ).append("\n"); 
		query.append(",	@[settle_dt]" ).append("\n"); 
		query.append(",	NVL(@[ous_qty],0)" ).append("\n"); 
		query.append(",	@[delt_flg]" ).append("\n"); 
		query.append(",   @[pic_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}