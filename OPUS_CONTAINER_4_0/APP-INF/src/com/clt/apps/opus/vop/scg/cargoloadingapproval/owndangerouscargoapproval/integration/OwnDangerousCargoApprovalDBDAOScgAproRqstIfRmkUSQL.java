/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgAproRqstIfRmkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.03 
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

public class OwnDangerousCargoApprovalDBDAOScgAproRqstIfRmkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgAproRqstIfRmk
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgAproRqstIfRmkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgAproRqstIfRmkUSQL").append("\n"); 
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
		query.append("UPDATE	SCG_APRO_RQST 				RQ" ).append("\n"); 
		query.append("SET		RQ.IF_RMK					= SUBSTR(RQ.IF_RMK,1,3000)||' <<<>>> '" ).append("\n"); 
		query.append("									  ||CHR(10)||'-------------------------------------------------------------'" ).append("\n"); 
		query.append("									  ||CHR(10)||' > '||'I/F TIME : ['||TO_CHAR(SYSTIMESTAMP,'YYYY-MM-DD HH24:MI:SS FF6')||']'" ).append("\n"); 
		query.append("									  ||CHR(10)||' > '||NVL(@[if_rmk]	,'Update Interfaced Result by System')" ).append("\n"); 
		query.append("									  ||CHR(10)||'============================================================='" ).append("\n"); 
		query.append("									  ||CHR(10)" ).append("\n"); 
		query.append("WHERE	RQ.BKG_NO           		= @[bkg_no]" ).append("\n"); 
		query.append("AND		RQ.SPCL_CGO_APRO_RQST_SEQ 	= @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 

	}
}