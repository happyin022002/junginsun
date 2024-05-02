/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOFincMtxVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.12 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class JointOperationMasterDataMgtDBDAOFincMtxVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_FINC_MTX insert
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOFincMtxVOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dr_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("insert into joo_finc_mtx (" ).append("\n"); 
		query.append("jo_crr_cd," ).append("\n"); 
		query.append("rlane_cd," ).append("\n"); 
		query.append("re_divr_cd," ).append("\n"); 
		query.append("jo_stl_itm_cd," ).append("\n"); 
		query.append("dr_ctr_cd," ).append("\n"); 
		query.append("dr_loc_cd," ).append("\n"); 
		query.append("cr_ctr_cd," ).append("\n"); 
		query.append("cr_loc_cd," ).append("\n"); 
		query.append("locl_curr_cd," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("upd_dt," ).append("\n"); 
		query.append("upd_usr_id" ).append("\n"); 
		query.append(") values(" ).append("\n"); 
		query.append("@[jo_crr_cd]," ).append("\n"); 
		query.append("@[rlane_cd]," ).append("\n"); 
		query.append("@[re_divr_cd]," ).append("\n"); 
		query.append("@[jo_stl_itm_cd]," ).append("\n"); 
		query.append("@[dr_ctr_cd]," ).append("\n"); 
		query.append("@[dr_loc_cd]," ).append("\n"); 
		query.append("@[cr_ctr_cd]," ).append("\n"); 
		query.append("@[cr_loc_cd]," ).append("\n"); 
		query.append("@[locl_curr_cd]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOFincMtxVOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}