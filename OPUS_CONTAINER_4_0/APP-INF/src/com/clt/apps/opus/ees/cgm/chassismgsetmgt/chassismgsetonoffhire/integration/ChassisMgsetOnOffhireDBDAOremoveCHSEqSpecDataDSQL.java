/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOremoveCHSEqSpecDataDSQL.java
*@FileTitle : Chassis Specification Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.21 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eui-su Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOremoveCHSEqSpecDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOremoveCHSEqSpecDataDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_spec_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM CGM_EQ_SPEC" ).append("\n"); 
		query.append("WHERE EQ_SPEC_NO = @[eq_spec_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOremoveCHSEqSpecDataDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}