/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOUpdateAproRqstForVVDChangeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOUpdateAproRqstForVVDChangeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updateAproRqstForVVDChange
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOUpdateAproRqstForVVDChangeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOUpdateAproRqstForVVDChangeUSQL").append("\n"); 
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
		query.append("UPDATE    	SCG_APRO_RQST             XX" ).append("\n"); 
		query.append("SET       	XX.VVD_CNG_FLG            = 'Y'" ).append("\n"); 
		query.append("WHERE     	1 = 1" ).append("\n"); 
		query.append("AND       	XX.SPCL_CGO_CATE_CD       = 'DG'" ).append("\n"); 
		query.append("AND       	XX.LST_RQST_DAT_FLG       = 'Y'" ).append("\n"); 
		query.append("AND			XX.BKG_NO                 = @[bkg_no]" ).append("\n"); 

	}
}