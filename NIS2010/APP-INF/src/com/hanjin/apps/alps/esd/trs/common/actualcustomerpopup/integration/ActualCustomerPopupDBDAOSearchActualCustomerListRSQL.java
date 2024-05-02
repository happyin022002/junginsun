/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualCustomerPopupDBDAOSearchActualCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCustomerPopupDBDAOSearchActualCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer Popup에서 Customer list 조회
	  * </pre>
	  */
	public ActualCustomerPopupDBDAOSearchActualCustomerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sBoundCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("factory_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sDorLocCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.integration ").append("\n"); 
		query.append("FileName : ActualCustomerPopupDBDAOSearchActualCustomerListRSQL").append("\n"); 
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
		query.append("#if (${sCustInfoIndicator} == 'EUR')" ).append("\n"); 
		query.append("SELECT  /*DISTINCT*/" ).append("\n"); 
		query.append("M.CUST_CNT_CD||M.CUST_SEQ     ACT_CUST_CD" ).append("\n"); 
		query.append(",M.CUST_CNT_CD                 ACT_CUST_CNT_CD   /* PK1 */" ).append("\n"); 
		query.append(",M.CUST_SEQ                    ACT_CUST_SEQ      /* PK2 */" ).append("\n"); 
		query.append(",M.CUST_LGL_ENG_NM             CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM    MDM_CUSTOMER                      M" ).append("\n"); 
		query.append(",TRS_TRSP_ACT_CUST_ADDR            A" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     M.CUST_CNT_CD            = A.ACT_CUST_CNT_CD   (+)" ).append("\n"); 
		query.append("AND     M.CUST_SEQ               = A.ACT_CUST_SEQ    (+)" ).append("\n"); 
		query.append("AND     NVL(M.NMD_CUST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND     1                        = A.ACT_CUST_ADDR_SEQ (+)" ).append("\n"); 
		query.append("AND     M.DELT_FLG               = 'N'" ).append("\n"); 
		query.append("AND     ROWNUM                   < 101" ).append("\n"); 
		query.append("#if (${sDorLocCd} != '' || ${act_cust_cd} != '' || ${factory_nm} != '')" ).append("\n"); 
		query.append("##${sDorLocCd}" ).append("\n"); 
		query.append("#if ($sDorLocCd.length() >= 2)" ).append("\n"); 
		query.append("AND M.LOC_CD      LIKE '%'||@[sDorLocCd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("##${act_cust_cd}" ).append("\n"); 
		query.append("#if ($act_cust_cd.length() >= 2)" ).append("\n"); 
		query.append("AND M.CUST_CNT_CD||M.CUST_SEQ  = @[act_cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${factory_nm} != '')" ).append("\n"); 
		query.append("AND A.FCTRY_NM  LIKE '%'||@[factory_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${sCustInfoIndicator} == 'XEUR')" ).append("\n"); 
		query.append("SELECT  C.ACT_CUST_CNT_CD||C.ACT_CUST_SEQ    ACT_CUST_CD" ).append("\n"); 
		query.append(",C.TRSP_ACT_CUST_NO                   TRSP_ACT_CUST_NO    /* PK */" ).append("\n"); 
		query.append(",C.ACT_CUST_CNT_CD                    ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",C.ACT_CUST_SEQ                       ACT_CUST_SEQ" ).append("\n"); 
		query.append(",C.ACT_CUST_NM                        CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM    TRS_TRSP_USA_ACT_CUST             C" ).append("\n"); 
		query.append(",TRS_TRSP_USA_ACT_CUST_DTL         D" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND  C.TRSP_ACT_CUST_NO      = D.TRSP_ACT_CUST_NO" ).append("\n"); 
		query.append("AND  C.ACT_CUST_BND_CD       = NVL(@[sBoundCd],C.ACT_CUST_BND_CD)" ).append("\n"); 
		query.append("AND  C.DELT_FLG              = 'N'" ).append("\n"); 
		query.append("AND  ROWNUM                  < 101" ).append("\n"); 
		query.append("#if (${sDorLocCd} != '' || ${act_cust_cd} != '' || ${factory_nm} != '')" ).append("\n"); 
		query.append("##${sDorLocCd}" ).append("\n"); 
		query.append("#if ($sDorLocCd.length() >= 2)" ).append("\n"); 
		query.append("AND C.DOR_NOD_CD       LIKE '%'||@[sDorLocCd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("##${act_cust_cd}" ).append("\n"); 
		query.append("#if ($act_cust_cd.length() > 0)" ).append("\n"); 
		query.append("AND C.ACT_CUST_CNT_CD||C.ACT_CUST_SEQ  = @[act_cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${factory_nm} != '')" ).append("\n"); 
		query.append("AND D.ACT_CUST_NM  LIKE '%'||@[factory_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  C.TRSP_ACT_CUST_NO" ).append("\n"); 
		query.append(",C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",C.ACT_CUST_SEQ" ).append("\n"); 
		query.append(",C.ACT_CUST_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}