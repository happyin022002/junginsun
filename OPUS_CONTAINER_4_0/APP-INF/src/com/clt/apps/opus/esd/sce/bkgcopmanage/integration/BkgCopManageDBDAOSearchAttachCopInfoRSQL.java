/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchAttachCopInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.24
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.09.24 김인수
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

public class BkgCopManageDBDAOSearchAttachCopInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking, container type size 로 조회하여 COP 를 붙일 대상을 찾는다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchAttachCopInfoRSQL(){
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
		params.put("org_cntrTpszCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchAttachCopInfoRSQL").append("\n"); 
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
		query.append("SELECT COP_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("OB_TRO_FLG," ).append("\n"); 
		query.append("IB_TRO_FLG" ).append("\n"); 
		query.append("FROM sce_cop_hdr" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND cntr_no = 'COMU0000000'" ).append("\n"); 
		query.append("AND PROV_CNTR_NO IS NULL" ).append("\n"); 
		query.append("AND cop_sts_cd not in ( 'X'," ).append("\n"); 
		query.append("'F'," ).append("\n"); 
		query.append("'O'," ).append("\n"); 
		query.append("'M' )" ).append("\n"); 
		query.append("--  AND prov_cntr_no is null" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - cntr_tpsz_cd */" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND cntr_tpsz_cd IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${org_cntrTpszCd} != '')" ).append("\n"); 
		query.append("order by decode (cntr_tpsz_cd, @[org_cntrTpszCd], 1, 2), cop_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}