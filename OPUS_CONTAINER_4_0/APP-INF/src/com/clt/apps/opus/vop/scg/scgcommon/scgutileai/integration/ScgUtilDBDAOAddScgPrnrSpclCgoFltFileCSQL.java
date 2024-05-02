/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ScgUtilDBDAOAddScgPrnrSpclCgoFltFileCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06 
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

public class ScgUtilDBDAOAddScgPrnrSpclCgoFltFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT
	  * SCG_PRNR_SPCL_CGO_FLT_FILE
	  * </pre>
	  */
	public ScgUtilDBDAOAddScgPrnrSpclCgoFltFileCSQL(){
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
		params.put("trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_msg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scgutileai.integration").append("\n"); 
		query.append("FileName : ScgUtilDBDAOAddScgPrnrSpclCgoFltFileCSQL").append("\n"); 
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
		query.append("INSERT INTO	SCG_PRNR_SPCL_CGO_FLT_FILE" ).append("\n"); 
		query.append("       		(	TRSM_BND_CD" ).append("\n"); 
		query.append("        	, 	PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("        	, 	BKG_REF_NO" ).append("\n"); 
		query.append("        	, 	FLT_FILE_DAT_CTNT" ).append("\n"); 
		query.append("        	, 	EXPT_MSG" ).append("\n"); 
		query.append("        	, 	CRE_USR_ID" ).append("\n"); 
		query.append("        	, 	CRE_DT" ).append("\n"); 
		query.append("        	, 	UPD_USR_ID" ).append("\n"); 
		query.append("        	, 	UPD_DT" ).append("\n"); 
		query.append("       		)" ).append("\n"); 
		query.append("VALUES		( 	NVL(@[trsm_bnd_cd]		,'X')" ).append("\n"); 
		query.append("       		, 	NVL(@[prnr_spcl_cgo_seq],SCG_PRNR_SPCL_CGO_SEQ.NEXTVAL)" ).append("\n"); 
		query.append("       		, 	@[bkg_ref_no]" ).append("\n"); 
		query.append("       		, 	@[flt_file_dat_ctnt]" ).append("\n"); 
		query.append("       		, 	SUBSTR(@[expt_msg],1,1000)" ).append("\n"); 
		query.append("       		, 	@[cre_usr_id]" ).append("\n"); 
		query.append("       		, 	SYSDATE" ).append("\n"); 
		query.append("       		, 	@[upd_usr_id]" ).append("\n"); 
		query.append("       		, 	SYSDATE" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}