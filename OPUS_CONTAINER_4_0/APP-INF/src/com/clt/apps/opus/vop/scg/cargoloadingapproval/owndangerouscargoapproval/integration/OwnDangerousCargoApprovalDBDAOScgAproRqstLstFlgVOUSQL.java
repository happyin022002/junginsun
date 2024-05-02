/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgAproRqstLstFlgVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.11.17 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgAproRqstLstFlgVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_APRO_RQST의 LST_RQST_DAT_FLG값을 N으로 변경한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgAproRqstLstFlgVOUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgAproRqstLstFlgVOUSQL").append("\n"); 
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
		query.append("UPDATE SCG_APRO_RQST SET" ).append("\n"); 
		query.append("LST_RQST_DAT_FLG = 'N'" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	SPCL_CGO_CATE_CD = @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("AND SPCL_CGO_RQST_SEQ = (	SELECT MAX(SPCL_CGO_RQST_SEQ) FROM SCG_APRO_RQST WHERE BKG_NO = @[bkg_no] AND SPCL_CGO_CATE_CD = @[spcl_cgo_cate_cd] )" ).append("\n"); 

	}
}