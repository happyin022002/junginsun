/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrLotLastSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchCntrLotLastSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrLotLastSeq
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrLotLastSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration ").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrLotLastSeqRSQL").append("\n"); 
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
		query.append("WITH PARAM AS(" ).append("\n"); 
		query.append("SELECT @[lot_pln_yr] AS LOT_PLN_YR," ).append("\n"); 
		query.append("@[lot_loc_cd] AS LOT_LOC_CD," ).append("\n"); 
		query.append("@[cntr_tpsz_cd] AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(A.LOT_SEQ),0,1,MAX(A.LOT_SEQ)+1) AS LOT_NO" ).append("\n"); 
		query.append("FROM MST_CNTR_LOT A, PARAM P" ).append("\n"); 
		query.append("WHERE A.LOT_PLN_YR  = P.LOT_PLN_YR" ).append("\n"); 
		query.append("AND A.LOT_LOC_CD    = P.LOT_LOC_CD" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD  = P.CNTR_TPSZ_CD" ).append("\n"); 

	}
}