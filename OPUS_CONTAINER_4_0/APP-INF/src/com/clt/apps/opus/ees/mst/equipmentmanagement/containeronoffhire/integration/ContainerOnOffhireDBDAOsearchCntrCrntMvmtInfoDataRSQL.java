/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchCntrCrntMvmtInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.08.28 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchCntrCrntMvmtInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Movement Information 조회
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchCntrCrntMvmtInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchCntrCrntMvmtInfoDataRSQL").append("\n"); 
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
		query.append("SELECT MC.CNTR_NO AS EQ_NO" ).append("\n"); 
		query.append("     , MC.CNMV_YR" ).append("\n"); 
		query.append("     , MC.CNMV_ID_NO" ).append("\n"); 
		query.append("     , MC.CNMV_STS_CD" ).append("\n"); 
		query.append("FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("WHERE MC.CNTR_NO     = @[eq_no]" ).append("\n"); 
		query.append("AND   MC.CNMV_STS_CD = 'XX'" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}