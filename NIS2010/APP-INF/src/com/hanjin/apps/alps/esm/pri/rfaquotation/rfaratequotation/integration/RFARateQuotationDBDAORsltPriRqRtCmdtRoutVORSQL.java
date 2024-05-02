/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriRqRtCmdtRoutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.30
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.11.30 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAORsltPriRqRtCmdtRoutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriRqRtCmdtRoutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPriRqRtCmdtRoutVORSQL").append("\n"); 
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
		query.append("SELECT  A2.QTTN_NO" ).append("\n"); 
		query.append(",       A2.QTTN_VER_NO" ).append("\n"); 
		query.append(",       A2.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",       A2.ROUT_SEQ" ).append("\n"); 
		query.append(",       A2.ORG_ROUT_PNT_LOC_DEF_CD            " ).append("\n"); 
		query.append(",       A2.ORG_ROUT_VIA_PORT_DEF_CD          " ).append("\n"); 
		query.append(",       A2.DEST_ROUT_VIA_PORT_DEF_CD         " ).append("\n"); 
		query.append(",       A2.DEST_ROUT_PNT_LOC_DEF_CD           " ).append("\n"); 
		query.append(",		@[src_info_cd] || '.' || ROWNUM AS SEQ" ).append("\n"); 
		query.append(",		A2.ORG_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append(",		A2.DEST_CY_DOR_RT_TP_CD	" ).append("\n"); 
		query.append(",		A2.ORG_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append(",		A2.DEST_BSE_PORT_LOC_CD	" ).append("\n"); 
		query.append("FROM	(		" ).append("\n"); 
		query.append("		SELECT  A1.QTTN_NO" ).append("\n"); 
		query.append("		,       A1.QTTN_VER_NO" ).append("\n"); 
		query.append("		,       A1.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		,       A1.ROUT_SEQ" ).append("\n"); 
		query.append("		,       B1.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD            --ORIGIN PNT" ).append("\n"); 
		query.append("		,       C1.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD          --ORIGIN VIA" ).append("\n"); 
		query.append("		,       D1.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD         --DEST VIA" ).append("\n"); 
		query.append("		,       E1.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD           --DEST PNT" ).append("\n"); 
		query.append("		,		A1.ORG_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("		,		A1.DEST_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("		,		B1.ORG_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("		,		E1.DEST_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("		        PRI_RQ_RT_CMDT_ROUT A1" ).append("\n"); 
		query.append("		        , (" ).append("\n"); 
		query.append("		        --ORIGIN POINT" ).append("\n"); 
		query.append("		        SELECT  QTTN_NO" ).append("\n"); 
		query.append("		        ,       QTTN_VER_NO" ).append("\n"); 
		query.append("		        ,       CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		        ,       ROUT_SEQ" ).append("\n"); 
		query.append("		        ,       ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		        ,       SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ',')),2) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		        ,       SUBSTR(MAX(SYS_CONNECT_BY_PATH(BSE_PORT_LOC_CD, ',')),2) AS ORG_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("		        FROM    (" ).append("\n"); 
		query.append("		                SELECT  A.QTTN_NO" ).append("\n"); 
		query.append("		                ,       A.QTTN_VER_NO" ).append("\n"); 
		query.append("		                ,       A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		                ,       A.ROUT_SEQ" ).append("\n"); 
		query.append("		                ,       A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		                ,       ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("						,       A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("					    ,		A.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("		                ,       ROW_NUMBER() OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		                        ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("		                                        A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ) AS RN" ).append("\n"); 
		query.append("		                FROM    PRI_RQ_RT_ROUT_PNT A" ).append("\n"); 
		query.append("		                WHERE   1=1" ).append("\n"); 
		query.append("		                AND   A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		                AND   A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		                AND   A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("		                AND   A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("		        )" ).append("\n"); 
		query.append("		        START WITH RN = 1" ).append("\n"); 
		query.append("		        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		        AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		        GROUP BY QTTN_NO" ).append("\n"); 
		query.append("		        ,        QTTN_VER_NO" ).append("\n"); 
		query.append("		        ,        CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		        ,        ROUT_SEQ" ).append("\n"); 
		query.append("		        ,        ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		        ) B1" ).append("\n"); 
		query.append("		        ,       (" ).append("\n"); 
		query.append("		        --ORIGIN VIA" ).append("\n"); 
		query.append("		        SELECT  QTTN_NO" ).append("\n"); 
		query.append("		        ,       QTTN_VER_NO" ).append("\n"); 
		query.append("		        ,       CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		        ,       ROUT_SEQ" ).append("\n"); 
		query.append("		        ,       ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		        ,       SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ',')),2) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		        FROM    (" ).append("\n"); 
		query.append("		                SELECT  A.QTTN_NO" ).append("\n"); 
		query.append("		                ,       A.QTTN_VER_NO" ).append("\n"); 
		query.append("		                ,       A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		                ,       A.ROUT_SEQ" ).append("\n"); 
		query.append("		                ,       A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		                ,       A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		                ,       ROW_NUMBER() OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		                        ORDER BY DECODE(A.ROUT_VIA_PORT_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("		                                        A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ) AS RN" ).append("\n"); 
		query.append("		                FROM    PRI_RQ_RT_ROUT_VIA A" ).append("\n"); 
		query.append("		                WHERE   1=1" ).append("\n"); 
		query.append("		                AND   A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		                AND   A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		                AND   A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("		                AND   A.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("		        )" ).append("\n"); 
		query.append("		        START WITH RN = 1" ).append("\n"); 
		query.append("		        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		        AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		        GROUP BY QTTN_NO" ).append("\n"); 
		query.append("		        ,        QTTN_VER_NO" ).append("\n"); 
		query.append("		        ,        CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		        ,        ROUT_SEQ" ).append("\n"); 
		query.append("		        ,        ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		        ) C1" ).append("\n"); 
		query.append("		        ,       (" ).append("\n"); 
		query.append("		        --DEST VIA" ).append("\n"); 
		query.append("		        SELECT  QTTN_NO" ).append("\n"); 
		query.append("		        ,       QTTN_VER_NO" ).append("\n"); 
		query.append("		        ,       CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		        ,       ROUT_SEQ" ).append("\n"); 
		query.append("		        ,       ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		        ,       SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ',')),2) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		        FROM    (" ).append("\n"); 
		query.append("		                SELECT  A.QTTN_NO" ).append("\n"); 
		query.append("		                ,       A.QTTN_VER_NO" ).append("\n"); 
		query.append("		                ,       A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		                ,       A.ROUT_SEQ" ).append("\n"); 
		query.append("		                ,       A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		                ,       A.ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("		                ,       ROW_NUMBER() OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		                        ORDER BY DECODE(A.ROUT_VIA_PORT_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_VIA_PORT_DEF_CD," ).append("\n"); 
		query.append("		                                        A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ) AS RN" ).append("\n"); 
		query.append("		                FROM    PRI_RQ_RT_ROUT_VIA A" ).append("\n"); 
		query.append("		                WHERE   1=1" ).append("\n"); 
		query.append("		                AND   A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		                AND   A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		                AND   A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("		                AND   A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("		        )" ).append("\n"); 
		query.append("		        START WITH RN = 1" ).append("\n"); 
		query.append("		        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		        AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		        GROUP BY QTTN_NO" ).append("\n"); 
		query.append("		        ,        QTTN_VER_NO" ).append("\n"); 
		query.append("		        ,        CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		        ,        ROUT_SEQ" ).append("\n"); 
		query.append("		        ,        ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		        ) D1" ).append("\n"); 
		query.append("		        ,       (" ).append("\n"); 
		query.append("		        --DEST POINT" ).append("\n"); 
		query.append("		        SELECT  QTTN_NO" ).append("\n"); 
		query.append("		        ,       QTTN_VER_NO" ).append("\n"); 
		query.append("		        ,       CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		        ,       ROUT_SEQ" ).append("\n"); 
		query.append("		        ,       ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		        ,       SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ',')),2) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("		        ,       SUBSTR(MAX(SYS_CONNECT_BY_PATH(BSE_PORT_LOC_CD, ',')),2) AS DEST_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("		        FROM    (" ).append("\n"); 
		query.append("		                SELECT  A.QTTN_NO" ).append("\n"); 
		query.append("		                ,       A.QTTN_VER_NO" ).append("\n"); 
		query.append("		                ,       A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		                ,       A.ROUT_SEQ" ).append("\n"); 
		query.append("		                ,       A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		                ,       ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("						,		A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("					    ,		A.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("		                ,       ROW_NUMBER() OVER(PARTITION BY A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		                        ORDER BY DECODE(A.ROUT_PNT_LOC_TP_CD, 'C','1','R','2','G','3','L','4'),  A.ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("		                                        A.QTTN_NO, A.QTTN_VER_NO, A.CMDT_HDR_SEQ, A.ROUT_SEQ) AS RN" ).append("\n"); 
		query.append("		                FROM    PRI_RQ_RT_ROUT_PNT A" ).append("\n"); 
		query.append("		                WHERE   1=1" ).append("\n"); 
		query.append("		                AND   A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		                AND   A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		                AND   A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("		                AND   A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("		        )" ).append("\n"); 
		query.append("		        START WITH RN = 1" ).append("\n"); 
		query.append("		        CONNECT BY PRIOR ROUT_SEQ = ROUT_SEQ" ).append("\n"); 
		query.append("		        AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("		        GROUP BY QTTN_NO" ).append("\n"); 
		query.append("		        ,        QTTN_VER_NO" ).append("\n"); 
		query.append("		        ,        CMDT_HDR_SEQ" ).append("\n"); 
		query.append("		        ,        ROUT_SEQ" ).append("\n"); 
		query.append("		        ,        ORG_DEST_TP_CD" ).append("\n"); 
		query.append("		        ) E1" ).append("\n"); 
		query.append("		WHERE   A1.QTTN_NO = B1.QTTN_NO(+)" ).append("\n"); 
		query.append("		AND     A1.QTTN_VER_NO = B1.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("		AND     A1.CMDT_HDR_SEQ = B1.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("		AND     A1.ROUT_SEQ = B1.ROUT_SEQ(+)" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND     A1.QTTN_NO = C1.QTTN_NO(+)" ).append("\n"); 
		query.append("		AND     A1.QTTN_VER_NO = C1.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("		AND     A1.CMDT_HDR_SEQ = C1.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("		AND     A1.ROUT_SEQ = C1.ROUT_SEQ(+)" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND     A1.QTTN_NO = D1.QTTN_NO(+)" ).append("\n"); 
		query.append("		AND     A1.QTTN_VER_NO = D1.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("		AND     A1.CMDT_HDR_SEQ = D1.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("		AND     A1.ROUT_SEQ = D1.ROUT_SEQ(+)" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND     A1.QTTN_NO = E1.QTTN_NO(+)" ).append("\n"); 
		query.append("		AND     A1.QTTN_VER_NO = E1.QTTN_VER_NO(+)" ).append("\n"); 
		query.append("		AND     A1.CMDT_HDR_SEQ = E1.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("		AND     A1.ROUT_SEQ = E1.ROUT_SEQ(+)" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND     A1.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("		AND     A1.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("		AND     A1.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		ORDER BY A1.ROUT_SEQ" ).append("\n"); 
		query.append("		) A2" ).append("\n"); 

	}
}