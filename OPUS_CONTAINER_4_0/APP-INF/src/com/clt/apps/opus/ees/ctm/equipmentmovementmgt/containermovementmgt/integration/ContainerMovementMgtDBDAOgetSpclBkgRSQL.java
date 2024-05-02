/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetSpclBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.02.04 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetSpclBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spcial Booking Check!
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetSpclBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cyc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cyc2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetSpclBkgRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED" ).append("\n"); 
		query.append("					INDEX(A  XAK1BKG_CONTAINER)" ).append("\n"); 
		query.append("					INDEX(B  XPKBKG_BOOKING)" ).append("\n"); 
		query.append("				*/" ).append("\n"); 
		query.append("       'A' FND" ).append("\n"); 
		query.append("  FROM CTM_BKG_CNTR A, CTM_BOOKING B" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND (A.CNMV_CYC_NO = @[cyc1] OR A.CNMV_CYC_NO = @[cyc2])" ).append("\n"); 
		query.append("   AND (   A.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("        OR A.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("        OR A.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("        OR A.RC_FLG = 'Y'" ).append("\n"); 
		query.append("        OR A.RD_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT /*+ ORDERED" ).append("\n"); 
		query.append("					INDEX(A  XAK1BKG_CONTAINER)" ).append("\n"); 
		query.append("					INDEX(B  XPKBKG_BOOKING)" ).append("\n"); 
		query.append("				*/" ).append("\n"); 
		query.append("       'A' FND" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND (A.CNMV_CYC_NO = @[cyc1] OR A.CNMV_CYC_NO = @[cyc2])" ).append("\n"); 
		query.append("   AND (   A.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("        OR A.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("        OR A.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("        OR A.RC_FLG = 'Y'" ).append("\n"); 
		query.append("        OR A.RD_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 

	}
}