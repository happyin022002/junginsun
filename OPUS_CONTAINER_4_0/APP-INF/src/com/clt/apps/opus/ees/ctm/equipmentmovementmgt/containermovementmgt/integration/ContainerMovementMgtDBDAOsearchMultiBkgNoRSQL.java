/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOsearchMultiBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOsearchMultiBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 하나의 컨테이너에 여러건의 부킹이 걸려있을 경우를 검색
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOsearchMultiBkgNoRSQL(){
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
		params.put("cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOsearchMultiBkgNoRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED INDEX_DESC(A XAK1BKG_CONTAINER) INDEX(B XPKBKG_BOOKING) */" ).append("\n"); 
		query.append("       B.VSL_CD," ).append("\n"); 
		query.append("       B.SKD_VOY_NO," ).append("\n"); 
		query.append("       B.SKD_DIR_CD," ).append("\n"); 
		query.append("       B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("#if ((${mvmt_sts_cd} == 'OP') || (${mvmt_sts_cd} == 'OC'))" ).append("\n"); 
		query.append("       C.SYS_AREA_GRP_ID AS SVR_ID," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       '' SVR_ID," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       B.POD_CD" ).append("\n"); 
		query.append("#if (${osca_bkg_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM CTM_BKG_CNTR A," ).append("\n"); 
		query.append("       CTM_BOOKING B" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER A," ).append("\n"); 
		query.append("       BKG_BOOKING B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${mvmt_sts_cd} == 'OP') || (${mvmt_sts_cd} == 'OC'))" ).append("\n"); 
		query.append("       ,COM_SYS_AREA_GRP_ID C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#if (${osca_bkg_flg} == 'Y')" ).append("\n"); 
		query.append("   AND A.CNMV_CYC_NO = @[cyc_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.CNMV_CYC_NO >= @[cyc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("#if ((${mvmt_sts_cd} == 'OP') || (${mvmt_sts_cd} == 'OC'))" ).append("\n"); 
		query.append("   AND SUBSTR (B.POR_CD, 1, 2) = C.CNT_CD" ).append("\n"); 
		query.append("   AND C.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND ROWNUM = 1 " ).append("\n"); 

	}
}