/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAQuotationMainDBDAORsltPriRqMnChkNeedCalcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.02 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAQuotationMainDBDAORsltPriRqMnChkNeedCalcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFAQuotationMainDBDAORsltPriRqMnChkNeedCalcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration").append("\n"); 
		query.append("FileName : RFAQuotationMainDBDAORsltPriRqMnChkNeedCalcVORSQL").append("\n"); 
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
		query.append("  --  RATE에 데이터가 존재 하는데 CALCULATE 를 실행 하지 않은 데이터가 있는지 검사한다." ).append("\n"); 
		query.append("	  -- 이런 데이터가 존재시 ADD VERSION, COPY TO PROPOSAL을 하지 못한다." ).append("\n"); 
		query.append("	SELECT A.QTTN_NO, A.QTTN_VER_NO,  DECODE( COUNT(*) , 0, 'N','Y')  AS NEED_CALC " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT ROUT.QTTN_NO, ROUT.QTTN_VER_NO " ).append("\n"); 
		query.append("		FROM PRI_RQ_RT_CMDT_ROUT ROUT" ).append("\n"); 
		query.append("		WHERE  ROUT.QTTN_NO = @[qttn_no]  " ).append("\n"); 
		query.append("			 AND	ROUT.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		GROUP BY ROUT.QTTN_NO, ROUT.QTTN_VER_NO " ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("	    , PRI_RQ_MN B" ).append("\n"); 
		query.append("	WHERE A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("	    AND A.QTTN_VER_NO = B.QTTN_VER_NO" ).append("\n"); 
		query.append("	    AND B.PRS_RT_CMPB_CALC_FLG = 'N'  " ).append("\n"); 
		query.append("	GROUP BY A.QTTN_NO, A.QTTN_VER_NO " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}