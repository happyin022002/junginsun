/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOVesselOperatorVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.23
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2011.02.23 장창수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JangChangSu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOVesselOperatorVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre Checking Report 화면의 Vessel Operator’s Prohibition 목록을 가져온다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOVesselOperatorVORSQL(){
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
		query.append("FileName : OwnDangerousCargoApprovalDBDAOVesselOperatorVORSQL").append("\n"); 
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
		query.append("SELECT B.CRR_CD" ).append("\n"); 
		query.append("FROM  BKG_VVD          A                  " ).append("\n"); 
		query.append("    , MDM_VSL_CNTR     B" ).append("\n"); 
		query.append("WHERE A.BKG_NO   = @[bkg_no]                " ).append("\n"); 
		query.append("AND A.VSL_CD   = B.VSL_CD" ).append("\n"); 
		query.append("AND B.CRR_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 

	}
}