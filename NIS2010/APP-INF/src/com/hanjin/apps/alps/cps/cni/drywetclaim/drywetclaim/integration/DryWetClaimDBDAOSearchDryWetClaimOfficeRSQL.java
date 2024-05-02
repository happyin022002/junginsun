/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchDryWetClaimOfficeRSQL.java
*@FileTitle : Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.26 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchDryWetClaimOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Code를 검사한다
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchDryWetClaimOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration ").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchDryWetClaimOfficeRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE	OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND	DELT_FLG = 'N'" ).append("\n"); 

	}
}