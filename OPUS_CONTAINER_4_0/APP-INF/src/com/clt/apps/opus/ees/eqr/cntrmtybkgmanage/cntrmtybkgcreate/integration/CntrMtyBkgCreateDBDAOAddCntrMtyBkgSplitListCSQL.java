/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOAddCntrMtyBkgSplitListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOAddCntrMtyBkgSplitListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG SPLIT 선택정보 EQR_CTRL_DAT_VRFY에 입력
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOAddCntrMtyBkgSplitListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vl_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vd_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOAddCntrMtyBkgSplitListCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_CTRL_DAT_VRFY" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    TMP_SEQ" ).append("\n"); 
		query.append("   ,TMP_DTL_SEQ " ).append("\n"); 
		query.append("   ,INP_MSG1    " ).append("\n"); 
		query.append("   ,INP_MSG2" ).append("\n"); 
		query.append("   ,INP_MSG3" ).append("\n"); 
		query.append("   ,INP_MSG4" ).append("\n"); 
		query.append("   ,INP_MSG5" ).append("\n"); 
		query.append("   ,INP_MSG6" ).append("\n"); 
		query.append("   ,INP_MSG7   " ).append("\n"); 
		query.append("   ,INP_MSG8    " ).append("\n"); 
		query.append("   ,INP_MSG9" ).append("\n"); 
		query.append("   ,INP_MSG10   -- vsl_cd" ).append("\n"); 
		query.append("   ,INP_MSG11   -- skd_voy_no" ).append("\n"); 
		query.append("   ,INP_MSG12   -- skd_dir_cd" ).append("\n"); 
		query.append("   ,INP_MSG13   -- pod_clpt_ind_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[tmp_seq]                      -- TMP_SEQ" ).append("\n"); 
		query.append("   ,@[seq]                          -- TMP_DTL_SEQ" ).append("\n"); 
		query.append("   ,@[vl_bkg_no]                    -- INP_MSG1" ).append("\n"); 
		query.append("   ,@[cntr_no]                      -- INP_MSG2" ).append("\n"); 
		query.append("   ,@[cntr_tpsz_cd]                 -- INP_MSG3" ).append("\n"); 
		query.append("   ,@[vd_bkg_no]                    -- INP_MSG4" ).append("\n"); 
		query.append("   ,@[pol_yd]                       -- INP_MSG5" ).append("\n"); 
		query.append("   ,@[clpt_seq]                     -- INP_MSG6" ).append("\n"); 
		query.append("   ,@[pod_yd_cd]                    -- INP_MSG7" ).append("\n"); 
		query.append("   ,@[to_etb_dt]                    -- INP_MSG8" ).append("\n"); 
		query.append("   ,@[mvmt_sts_cd]                  -- INP_MSG9" ).append("\n"); 
		query.append("   ,@[vsl_cd]                       -- INP_MSG10" ).append("\n"); 
		query.append("   ,@[skd_voy_no]                   -- INP_MSG11" ).append("\n"); 
		query.append("   ,@[skd_dir_cd]                   -- INP_MSG12" ).append("\n"); 
		query.append("   ,@[pod_clpt_ind_seq]             -- INP_MSG13" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   ,@[usr_id]" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,@[usr_id]   " ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}