/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOMultiSpcSbBkgDtlDelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.10.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOMultiSpcSbBkgDtlDelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_SB_BKG_DTL 테이블에 DELETE FLAG = 'Y' 처리
	  * </pre>
	  */
	public ConstraintMasterDBDAOMultiSpcSbBkgDtlDelUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOMultiSpcSbBkgDtlDelUSQL").append("\n"); 
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
		query.append("UPDATE SPC_SB_BKG_DTL" ).append("\n"); 
		query.append("   SET DELT_FLG        = 'Y'" ).append("\n"); 
		query.append("     , UPD_USR_ID      = @[cfm_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT          = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO 		   = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_CTRL_TP_CD  = 'S'" ).append("\n"); 

	}
}