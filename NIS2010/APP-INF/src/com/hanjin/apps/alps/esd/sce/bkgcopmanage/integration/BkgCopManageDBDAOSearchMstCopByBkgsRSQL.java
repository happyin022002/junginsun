/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchMstCopByBkgsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.18 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchMstCopByBkgsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 동일 container 가 여럿 잡혀있는 지정된 bkg 중 master cop no 가 지정된 cop_no, bkg_no, cntr_no 를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchMstCopByBkgsRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchMstCopByBkgsRSQL").append("\n"); 
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
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  CNTR_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE BKG_NO IN (" ).append("\n"); 
		query.append("		#foreach($ele IN ${bkg_no})" ).append("\n"); 
		query.append("			#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("				'$ele'" ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				,'$ele' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("  AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND MST_COP_NO = COP_NO" ).append("\n"); 
		query.append("  AND COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}