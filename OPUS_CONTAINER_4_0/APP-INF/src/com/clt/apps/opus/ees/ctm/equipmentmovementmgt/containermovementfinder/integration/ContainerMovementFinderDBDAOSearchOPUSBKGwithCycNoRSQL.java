/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchOPUSBKGwithCycNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchOPUSBKGwithCycNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOPUSBKGwithCycNo
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchOPUSBKGwithCycNoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchOPUSBKGwithCycNoRSQL").append("\n"); 
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
		query.append("SELECT BC.BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER BC, BKG_BOOKING BB" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND BC.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("#if (${cnmv_cyc_no} != '9999') " ).append("\n"); 
		query.append("   AND BC.CNMV_STS_CD NOT IN ('ID', 'MT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("   AND BB.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("   AND BB.BKG_STS_CD != 'S'" ).append("\n"); 

	}
}