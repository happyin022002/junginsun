/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchDiffCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.04.10 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchDiffCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_container 에 존재하는 tpsz 별 container 가 cop 에 모두 존재하는 지, 
	  * sce_cop_hdr 에 존재하는 tpsz 별 container 가 bkg_container 에 모두 존재하는 지
	  * 를 각각 확인하여 존재하지 않는 container 를 추출한다.
	  * 추출된 list 를 가지고 container attach / detach 를 시도한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchDiffCntrListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchDiffCntrListRSQL").append("\n"); 
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
		query.append("SELECT 'CA' AS BKG_EVNT_TP_CD," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER A" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT '1'" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND COP_STS_CD != 'X')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'CD' AS BKG_EVNT_TP_CD," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] AND CNTR_NO != 'COMU0000000'" ).append("\n"); 
		query.append("AND COP_STS_CD != 'X'" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT '1'" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND NVL(CNTR_DELT_FLG, 'N') = 'N')" ).append("\n"); 

	}
}