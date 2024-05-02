/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOSearchBfSplitBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.02.24 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchBfSplitBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * split 되기 이전의 bkg 정보를 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchBfSplitBkgInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchBfSplitBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT BBK.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("BBK.BKG_STS_CD AS BKG_STS_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BBK," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT FM_BKG_NO -- SPLIT 하기 전 원 BOOKING NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_CRE_TP_CD = 'S' -- SPLIT" ).append("\n"); 
		query.append(") BK" ).append("\n"); 
		query.append("WHERE BBK.BKG_NO = BK.FM_BKG_NO" ).append("\n"); 

	}
}