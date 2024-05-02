/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrStatusCntCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.07 
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

public class ContainerOnOffhireDBDAOSearchCntrStatusCntCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Status 삭제전 데이타 유무 확인
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrStatusCntCheckRSQL(){
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
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrStatusCntCheckRSQL").append("\n"); 
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
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("       , BKG_CONTAINER BC" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND    BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    BB.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("AND    EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                     FROM MST_CNTR_STS_HIS HIS" ).append("\n"); 
		query.append("                     WHERE BC.CNTR_NO = HIS.CNTR_NO" ).append("\n"); 
		query.append("                     GROUP BY CNTR_NO" ).append("\n"); 
		query.append("                     HAVING COUNT(*) < 2)" ).append("\n"); 
		query.append("AND   ROWNUM = 1 " ).append("\n"); 

	}
}