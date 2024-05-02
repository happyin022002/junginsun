/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ScgUtilDBDAOModifyScgPrnrSpclCgoFltFileUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgutileai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScgUtilDBDAOModifyScgPrnrSpclCgoFltFileUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Flat File Log 업데이트
	  * </pre>
	  */
	public ScgUtilDBDAOModifyScgPrnrSpclCgoFltFileUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flt_file_dat_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("expt_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scgutileai.integration").append("\n"); 
		query.append("FileName : ScgUtilDBDAOModifyScgPrnrSpclCgoFltFileUSQL").append("\n"); 
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
		query.append("UPDATE  SCG_PRNR_SPCL_CGO_FLT_FILE X" ).append("\n"); 
		query.append("SET     X.BKG_REF_NO               = @[bkg_ref_no]" ).append("\n"); 
		query.append("     ,  X.FLT_FILE_DAT_CTNT        = @[flt_file_dat_ctnt]" ).append("\n"); 
		query.append("     ,  X.EXPT_MSG                 = SUBSTR(@[expt_msg],1,1000)" ).append("\n"); 
		query.append("     ,  X.CRE_USR_ID               = @[cre_usr_id]" ).append("\n"); 
		query.append("     ,  X.CRE_DT                   = SYSDATE" ).append("\n"); 
		query.append("     ,  X.UPD_USR_ID               = @[upd_usr_id]" ).append("\n"); 
		query.append("     ,  X.UPD_DT                   = SYSDATE" ).append("\n"); 
		query.append("WHERE   X.TRSM_BND_CD              = @[trsm_bnd_cd]" ).append("\n"); 
		query.append("AND     X.PRNR_SPCL_CGO_SEQ        = @[prnr_spcl_cgo_seq]" ).append("\n"); 

	}
}