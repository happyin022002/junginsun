/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.11.05 정재엽
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrCntrRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrCntrRSQL").append("\n"); 
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
		query.append("SELECT B.CNTR_NO, B.CNTR_TPSZ_CD, C.CNTR_SEAL_NO," ).append("\n"); 
		query.append("CASE WHEN A.BKG_CGO_TP_CD IN ('P', 'R') THEN 'M' ELSE 'F' END AS FM," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.BL_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING A, BKG_CONTAINER B, BKG_CNTR_SEAL_NO C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND A.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.BKG_NO     = A.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_NO(+)  = B.BKG_NO" ).append("\n"); 
		query.append("AND C.CNTR_NO(+) = B.CNTR_NO" ).append("\n"); 
		query.append("AND C.CNTR_SEAL_SEQ(+) = 1" ).append("\n"); 

	}
}