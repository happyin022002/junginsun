/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrLotSerialRangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.08 
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

public class ContainerOnOffhireDBDAOSearchCntrLotSerialRangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrLotSerialRange
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrLotSerialRangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_cntr_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrLotSerialRangeRSQL").append("\n"); 
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
		query.append("SELECT A.LOT_PLN_YR" ).append("\n"); 
		query.append("       ,A.LOT_LOC_CD" ).append("\n"); 
		query.append("       ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,A.LOT_SEQ" ).append("\n"); 
		query.append("FROM   MST_CNTR_LOT A" ).append("\n"); 
		query.append("WHERE A.LOT_CNTR_PFX_CD = @[lot_cntr_pfx_cd]" ).append("\n"); 
		query.append("AND TO_NUMBER(A.FM_SER_NO) >= TO_NUMBER(@[fm_ser_no]) " ).append("\n"); 
		query.append("AND TO_NUMBER(A.FM_SER_NO) <= TO_NUMBER(@[to_ser_no])" ).append("\n"); 

	}
}