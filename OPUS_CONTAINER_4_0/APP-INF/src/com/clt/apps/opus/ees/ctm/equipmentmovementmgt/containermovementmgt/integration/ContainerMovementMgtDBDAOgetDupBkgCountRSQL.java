/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetDupBkgCountRSQL.java
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

public class ContainerMovementMgtDBDAOgetDupBkgCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 부킹 컨테이너에서 마지막 부킹및 vvd의 갯수를 구한다
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetDupBkgCountRSQL(){
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
		query.append("FileName : ContainerMovementMgtDBDAOgetDupBkgCountRSQL").append("\n"); 
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
		query.append("							INDEX(A  XAK1BKG_CONTAINER)" ).append("\n"); 
		query.append("							INDEX(B  XPKBKG_BOOKING)" ).append("\n"); 
		query.append("						*/" ).append("\n"); 
		query.append("       COUNT (DISTINCT (   B.VSL_CD" ).append("\n"); 
		query.append("                        || B.SKD_VOY_NO" ).append("\n"); 
		query.append("                        || B.SKD_DIR_CD" ).append("\n"); 
		query.append("                        || B.BKG_CGO_TP_CD)" ).append("\n"); 
		query.append("             ) DUP_CNT," ).append("\n"); 
		query.append("       COUNT (A.BKG_NO) CNT" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND (CNMV_CYC_NO = @[cyc1] OR CNMV_CYC_NO = @[cyc2])" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 

	}
}