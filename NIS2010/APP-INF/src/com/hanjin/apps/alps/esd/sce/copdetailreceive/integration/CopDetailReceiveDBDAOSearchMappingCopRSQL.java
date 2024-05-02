/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchMappingCopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.03 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchMappingCopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMappingCop
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchMappingCopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inBkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCntrNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchMappingCopRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(SCE_COP_HDR XAK3SCE_COP_HDR) */" ).append("\n"); 
		query.append("REFND.BKG_NO, REFND.COP_NO, REFND.MST_COP_NO" ).append("\n"); 
		query.append("SELECT CUR.MST_COP_NO, REFND.COP_NO" ).append("\n"); 
		query.append(",DECODE(CUR.COP_STS_CD,'F','F','C','T','T','T') CUR_STS_CD" ).append("\n"); 
		query.append(",CUR.BKG_NO,CUR.CNTR_NO,REFND.CNTR_NO,REFND.BKG_NO" ).append("\n"); 
		query.append(",CUR.POL_NOD_CD,CUR.POD_NOD_CD,CUR.TRNK_VSL_CD,CUR.TRNK_SKD_VOY_NO,CUR.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",REFND.POL_NOD_CD,REFND.POD_NOD_CD,REFND.TRNK_VSL_CD,REFND.TRNK_SKD_VOY_NO,REFND.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM   SCE_COP_HDR CUR, SCE_COP_HDR REFND" ).append("\n"); 
		query.append("WHERE  CUR.BKG_NO                = @[inBkgNo]" ).append("\n"); 
		query.append("AND    CUR.CNTR_NO               = @[inCntrNo]" ).append("\n"); 
		query.append("AND    REFND.CNTR_NO             = CUR.CNTR_NO" ).append("\n"); 
		query.append("AND    (CASE WHEN CUR.COP_STS_CD IN ('C','T') AND REFND.COP_STS_CD IN ('C','T') THEN 'SUCC'" ).append("\n"); 
		query.append("WHEN CUR.COP_STS_CD = 'F' AND REFND.COP_STS_CD = 'F' THEN 'SUCC' ELSE 'FAIL' END) = 'SUCC'" ).append("\n"); 
		query.append("AND    NVL(REFND.POL_NOD_CD,'X') = NVL(CUR.POL_NOD_CD,'X')" ).append("\n"); 
		query.append("AND    NVL(REFND.POD_NOD_CD,'X') = NVL(CUR.POD_NOD_CD,'X')" ).append("\n"); 
		query.append("AND    REFND.TRNK_VSL_CD         = CUR.TRNK_VSL_CD" ).append("\n"); 
		query.append("AND    REFND.TRNK_SKD_VOY_NO     = CUR.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("AND    REFND.TRNK_SKD_DIR_CD     = CUR.TRNK_SKD_DIR_CD" ).append("\n"); 

	}
}