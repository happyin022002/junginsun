/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetBkgContainerLastCycleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetBkgContainerLastCycleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 부킹 컨테이너에서 마지막 상태값을 가진 최종 데이타를 구한다
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetBkgContainerLastCycleRSQL(){
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
		query.append("FileName : ContainerMovementMgtDBDAOgetBkgContainerLastCycleRSQL").append("\n"); 
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
		query.append("SELECT /*+  ORDERED" ).append("\n"); 
		query.append("					 INDEX_DESC(A  XAK1BKG_CONTAINER)" ).append("\n"); 
		query.append("					 INDEX(B XPKBKG_BOOKING)" ).append("\n"); 
		query.append("				*/" ).append("\n"); 
		query.append("				A.BKG_NO, 		" ).append("\n"); 
		query.append("				A.CNMV_CYC_NO," ).append("\n"); 
		query.append("				B.VSL_CD, 		" ).append("\n"); 
		query.append("				B.SKD_VOY_NO, 	" ).append("\n"); 
		query.append("				B.SKD_DIR_CD," ).append("\n"); 
		query.append("				B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("				B.POD_CD," ).append("\n"); 
		query.append("				B.DEL_CD," ).append("\n"); 
		query.append("                A.BB_CGO_FLG," ).append("\n"); 
		query.append("                B.MTY_SPLIT_AVAL_CD" ).append("\n"); 
		query.append("		   FROM BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append("		  WHERE A.CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("			AND A.CNMV_CYC_NO = (" ).append("\n"); 
		query.append("									SELECT /*+ ORDERED" ).append("\n"); 
		query.append("											INDEX_DESC(BC XAK1BKG_CONTAINER)" ).append("\n"); 
		query.append("											INDEX(BO XPKBKG_BOOKING) */" ).append("\n"); 
		query.append("											MAX(CNMV_CYC_NO)" ).append("\n"); 
		query.append("									  FROM BKG_CONTAINER BC, BKG_BOOKING BO" ).append("\n"); 
		query.append("									 WHERE  BC.CNTR_NO      = @[cntr_no]" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("                                       AND  BC.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                       AND  BC.BKG_NO       = BO.BKG_NO" ).append("\n"); 
		query.append("									   AND  NVL(BO.BKG_STS_CD,' ') <> 'X'" ).append("\n"); 
		query.append("									   AND  NVL(BO.BKG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("			AND A.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("			AND NVL(B.BKG_STS_CD,' ') <> 'X'" ).append("\n"); 
		query.append("			AND NVL(B.BKG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("			AND ROWNUM = 1" ).append("\n"); 

	}
}