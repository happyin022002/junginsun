/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetBkgDupCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.07.16 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetBkgDupCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trunk VVD의 중복 체크
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetBkgDupCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetBkgDupCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT (DISTINCT (   BO.VSL_CD" ).append("\n"); 
		query.append("|| BO.SKD_VOY_NO" ).append("\n"); 
		query.append("|| BO.SKD_DIR_CD" ).append("\n"); 
		query.append("|| BO.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") CNT" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC, BKG_BOOKING BO" ).append("\n"); 
		query.append("WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#if (${mvmt_sts_cd} == 'VL')" ).append("\n"); 
		query.append("AND BC.CNMV_CYC_NO >=" ).append("\n"); 
		query.append("DECODE (@[mvmt_sts_cd]," ).append("\n"); 
		query.append("'MT', @[cnmv_cyc_no] + 1," ).append("\n"); 
		query.append("DECODE (@[mvmt_sts_cd],'EN', @[cnmv_cyc_no] + 1," ).append("\n"); 
		query.append("DECODE (@[mvmt_sts_cd], 'TN', @[cnmv_cyc_no] + 1, @[cnmv_cyc_no])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND BC.CNMV_CYC_NO >= @[cnmv_cyc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("AND NVL (BO.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("AND NVL (BO.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 

	}
}