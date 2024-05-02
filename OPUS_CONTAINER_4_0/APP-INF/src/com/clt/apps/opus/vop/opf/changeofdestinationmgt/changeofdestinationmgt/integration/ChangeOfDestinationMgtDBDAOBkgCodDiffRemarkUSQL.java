/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOBkgCodDiffRemarkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOBkgCodDiffRemarkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_COD테이블의 Remark를 update한다.
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOBkgCodDiffRemarkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOBkgCodDiffRemarkUSQL").append("\n"); 
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
		query.append("UPDATE BKG_COD SET " ).append("\n"); 
		query.append("  UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("  ,	UPD_DT = sysdate" ).append("\n"); 
		query.append("  ,	DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 

	}
}