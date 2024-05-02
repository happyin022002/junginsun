/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseInfoManageDBDAOCheckHireECCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.04 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseInfoManageDBDAOCheckHireECCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/T on-hire, S/T off-hire, L/T off-hire 검색시 update 시 기존 데이터가 있는지 없는지 확인을 위한 쿼리.
	  * </pre>
	  */
	public LeaseInfoManageDBDAOCheckHireECCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration ").append("\n"); 
		query.append("FileName : LeaseInfoManageDBDAOCheckHireECCRSQL").append("\n"); 
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
		query.append("SELECT	COUNT(*) CNT" ).append("\n"); 
		query.append("FROM	EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE	ECC_CD		= @[ecc_cd]" ).append("\n"); 
		query.append("AND	DELT_FLG	= 'N'" ).append("\n"); 

	}
}