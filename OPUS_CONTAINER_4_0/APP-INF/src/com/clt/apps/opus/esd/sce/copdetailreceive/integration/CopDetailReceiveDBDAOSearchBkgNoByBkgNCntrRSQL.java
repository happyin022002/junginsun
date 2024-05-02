/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchBkgNoByBkgNCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchBkgNoByBkgNCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bkg no + Cntr No 로 Actual Mapping을 시도할 cop info를 조회한다.
	  * Partial건은 포함하지 않는다.
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchBkgNoByBkgNCntrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchBkgNoByBkgNCntrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("H.BKG_NO," ).append("\n"); 
		query.append("H.CNTR_NO," ).append("\n"); 
		query.append("H.COP_NO," ).append("\n"); 
		query.append("H.MST_COP_NO," ).append("\n"); 
		query.append("H.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("(SELECT B.BL_NO FROM BKG_BOOKING B WHERE H.BKG_NO = B.BKG_NO) BL_NO" ).append("\n"); 
		query.append(",H.POD_NOD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_COP_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND H.COP_STS_CD <> 'X'" ).append("\n"); 

	}
}