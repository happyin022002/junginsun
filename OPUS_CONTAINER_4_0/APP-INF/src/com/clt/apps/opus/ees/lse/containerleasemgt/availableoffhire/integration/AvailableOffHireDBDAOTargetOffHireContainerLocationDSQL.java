/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AvailableOffHireDBDAOTargetOffHireContainerLocationDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOTargetOffHireContainerLocationDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target Off-hire location 삭제
	  * </pre>
	  */
	public AvailableOffHireDBDAOTargetOffHireContainerLocationDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOTargetOffHireContainerLocationDSQL").append("\n"); 
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
		query.append("DELETE FROM " ).append("\n"); 
		query.append("   LSE_AGMT_OFFH_PLC WHERE 1=1" ).append("\n"); 
		query.append("AND AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[cntr_tpsz_cd] " ).append("\n"); 

	}
}