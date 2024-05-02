/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAORemoveCntrLotDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAORemoveCntrLotDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MST_CONTAINER 데이타를 조회하여 데이타가 존재하지 않으면 MST_CNTR_LOT 데이타 삭제
	  * </pre>
	  */
	public ContainerOnOffhireDBDAORemoveCntrLotDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAORemoveCntrLotDataDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM MST_CNTR_LOT LOT" ).append("\n"); 
		query.append("WHERE LOT.LOT_CNTR_PFX_CD = SUBSTR(@[cntr_no], 1, 4)" ).append("\n"); 
		query.append("AND SUBSTR(@[cntr_no], 5, 6 ) BETWEEN LOT.FM_SER_NO AND LOT.TO_SER_NO" ).append("\n"); 
		query.append("AND NOT EXISTS ( " ).append("\n"); 
		query.append("	SELECT 'X'" ).append("\n"); 
		query.append("    	FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("        WHERE LOT.LOT_PLN_YR  =  MC.LOT_PLN_YR" ).append("\n"); 
		query.append("        AND LOT.LOT_LOC_CD    =  MC.LOT_LOC_CD" ).append("\n"); 
		query.append("        AND LOT.CNTR_TPSZ_CD  =  MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND LOT.LOT_SEQ       = MC.LOT_SEQ" ).append("\n"); 
		query.append(") " ).append("\n"); 

	}
}