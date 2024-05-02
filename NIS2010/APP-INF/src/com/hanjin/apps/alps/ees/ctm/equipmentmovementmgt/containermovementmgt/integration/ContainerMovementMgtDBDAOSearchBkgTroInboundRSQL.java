/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchBkgTroInboundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.28
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.11.28 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchBkgTroInboundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Carrier's Haulage 를 조회한다.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchBkgTroInboundRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchBkgTroInboundRSQL").append("\n"); 
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
		query.append("SELECT BE.HLG_TP_CD HLG_TP_CD " ).append("\n"); 
		query.append("  FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     , BKG_EUR_TRO BE" ).append("\n"); 
		query.append(" WHERE BB.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("   AND BB.BKG_NO  = BE.BKG_NO " ).append("\n"); 
		query.append("   AND BE.CNTR_NO = @[cntr_no] " ).append("\n"); 
		query.append("   AND BE.IO_BND_CD = 'I' " ).append("\n"); 
		query.append("   AND BE.HLG_TP_CD = 'C' " ).append("\n"); 
		query.append("   AND ROWNUM = 1 " ).append("\n"); 

	}
}